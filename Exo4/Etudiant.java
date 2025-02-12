package Exo4;

public class Etudiant {
    private String nom;
    private int age;
    private String filiere;

    // Constructeur
    public Etudiant(String nom, int age, String filiere) {
        this.nom = nom;
        this.age = age;
        this.filiere = filiere;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Méthode toString pour afficher les détails de l'étudiant
    @Override
    public String toString() {
        return "Nom: " + nom + ", Âge: " + age + ", Filière: " + filiere;
    }
}