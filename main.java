public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture();
        voiture.couleur = "Rouge";
        voiture.marque = "Toyota";
        voiture.modele = "Corolla";

        voiture.demarrer();
        voiture.accelerer();
        voiture.freiner();
    }
}