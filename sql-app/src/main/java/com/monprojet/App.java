package com.monprojet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        try (Scanner sc = new Scanner(System.in)) {
            Connexion connexion = new Connexion();
            GestionUtilisateur gu = new GestionUtilisateur();
            int choix = -1;

            do {
                System.out.println("\nQue voulez-vous faire ?");
                System.out.println("1 - Ajouter un utilisateur");
                System.out.println("2 - Lister les utilisateurs (depuis la liste temporaire)");
                System.out.println("3 - Supprimer un utilisateur par ID");
                System.out.println("0 - Quitter");

                try {
                    System.out.print("Votre choix : ");
                    choix = sc.nextInt();
                    sc.nextLine(); // Pour éviter les erreurs après nextInt()

                    switch (choix) {
                        case 1:
                            gu.add(connexion, sc);
                            break;
                        case 2:
                            gu.listerUtilisateurs();
                            break;
                        case 3:
                            gu.deleteUserById(connexion, sc);
                            break;
                        case 0:
                            System.out.println("Fermeture du programme...");
                            break;
                        default:
                            System.out.println("L'action demandée n'existe pas !");
                    }
                } catch (Exception e) {
                    System.err.println("Erreur : Veuillez entrer un nombre valide.");
                    sc.nextLine(); // Pour éviter la boucle infinie
                    continue;
                }
            } while (choix != 0);

            connexion.close();
        }

        System.exit(0);
    }
}
