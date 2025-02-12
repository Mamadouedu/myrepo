package Exo4;

public class Etudiant {
    private String nom;
    private int age;
    private String filiere;

    public Etudiant(String nom, int age, String filiere) {
        this.nom = nom;
        this.age = age;
        this.filiere = filiere;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Âge: " + age + ", Filière: " + filiere;
    }
}