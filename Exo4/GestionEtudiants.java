package Exo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionEtudiants {
    private ArrayList<Etudiant> listeEtudiants = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Âge : ");
        int age = 0;
        try {
            age = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
        } catch (Exception e) {
            System.out.println("Veuillez entrer un âge valide.");
            scanner.nextLine(); // Pour consommer l'entrée invalide
            return;
        }
        System.out.print("Filière : ");
        String filiere = scanner.nextLine();

        listeEtudiants.add(new Etudiant(nom, age, filiere));
        System.out.println("Étudiant ajouté avec succès !");
    }

    // Méthode pour afficher la liste des étudiants
    public void afficherEtudiants() {
        if (listeEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant enregistré.");
        } else {
            System.out.println("\nListe des étudiants :");
            for (Etudiant etudiant : listeEtudiants) {
                System.out.println(etudiant);
            }
        }
    }

    // Méthode pour supprimer un étudiant par son nom
    public void supprimerEtudiant() {
        System.out.print("Entrez le nom de l'étudiant à supprimer : ");
        String nom = scanner.nextLine();

        Iterator<Etudiant> iterator = listeEtudiants.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Etudiant etudiant = iterator.next();
            if (etudiant.getNom().equalsIgnoreCase(nom)) {
                iterator.remove();
                found = true;
                System.out.println("Étudiant supprimé avec succès !");
                break;
            }
        }

        if (!found) {
            System.out.println("Aucun étudiant trouvé avec ce nom.");
        }
    }
}