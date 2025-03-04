package com.monprojet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionUtilisateur {
    private List<Utilisateur> listUser = new ArrayList<>();

    // Classe interne représentant un utilisateur
    private static class Utilisateur {
        int id; // Ajout de l'ID
        String nom, prenom, email;

        public Utilisateur(int id, String nom, String prenom, String email) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID : " + id + ", Nom : " + nom + ", Prénom : " + prenom + ", Email : " + email;
        }
    }

    public void add(Connexion connect, Scanner sc) {
        System.out.print("Nom de l'utilisateur : ");
        String lastName = sc.nextLine().trim();

        System.out.print("Prénom de l'utilisateur : ");
        String firstName = sc.nextLine().trim();

        System.out.print("Email de l'utilisateur : ");
        String email = sc.nextLine().trim();

        // Validation email
        if (!isValidEmail(email)) {
            System.err.println("Email invalide. Veuillez saisir une adresse email valide.");
            return;
        }

        // Vérifier si l'utilisateur existe déjà en base
        if (userExists(connect, email)) {
            System.err.println("Erreur : Un utilisateur avec cet email existe déjà.");
            return;
        }

        // Insérer dans la base de données
        try (PreparedStatement pstmtInsert = connect.getConnection().prepareStatement(
                "INSERT INTO utilisateurs (nom, prenom, email) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmtInsert.setString(1, lastName);
            pstmtInsert.setString(2, firstName);
            pstmtInsert.setString(3, email);

            int rowsAffected = pstmtInsert.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur ajouté avec succès.");
                try (ResultSet rs = pstmtInsert.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        listUser.add(new Utilisateur(id, lastName, firstName, email));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    public void deleteUserById(Connexion connect, Scanner sc) {
        System.out.print("Entrez l'ID de l'utilisateur à supprimer : ");
        int userId;

        try {
            userId = sc.nextInt();
            sc.nextLine(); // Consommer la nouvelle ligne
        } catch (Exception e) {
            System.err.println("Erreur : Veuillez entrer un nombre valide.");
            sc.nextLine(); // Nettoyer le buffer
            return;
        }

        // Suppression de la base de données
        try (PreparedStatement pstmtDelete = connect.getConnection().prepareStatement(
                "DELETE FROM utilisateurs WHERE id = ?")) {
            pstmtDelete.setInt(1, userId);

            int rowsAffected = pstmtDelete.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès.");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
                return;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            return;
        }

        // Suppression de la liste temporaire
        listUser.removeIf(user -> user.id == userId);
    }

    public void listerUtilisateurs() {
        if (listUser.isEmpty()) {
            System.out.println("Aucun utilisateur dans la liste.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (Utilisateur user : listUser) {
                System.out.println(user);
            }
        }
    }

    private boolean userExists(Connexion connect, String email) {
        try (PreparedStatement pstmt = connect.getConnection().prepareStatement(
                "SELECT COUNT(*) FROM utilisateurs WHERE email = ?")) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la vérification de l'existence de l'utilisateur : " + e.getMessage());
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
