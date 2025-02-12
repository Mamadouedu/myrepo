package Exo4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionEtudiants gestionEtudiants = new GestionEtudiants();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher la liste des étudiants");
            System.out.println("3. Supprimer un étudiant par son nom");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = 0;
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.nextLine();
                continue;
            }

            switch (choix) {
                case 1:
                    gestionEtudiants.ajouterEtudiant();
                    break;
                case 2:
                    gestionEtudiants.afficherEtudiants();
                    break;
                case 3:
                    gestionEtudiants.supprimerEtudiant();
                    break;
                case 4:
                    System.out.println("Programme terminé.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}1