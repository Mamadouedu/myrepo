public class Voiture {
    private String couleur;
    private String marque;
    private String modele;

    public Voiture(String couleur, String marque, String modele) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
    }

    public void demarrer() {
        System.out.println("La voiture " + marque + " " + modele + " démarre.");
    }

    public void accelerer() {
        System.out.println("La voiture " + marque + " " + modele + " accélère.");
    }

    public void freiner() {
        System.out.println("La voiture " + marque + " " + modele + " freine.");
    }
}