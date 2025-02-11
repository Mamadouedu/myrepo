class Voiture {
    String couleur;
    String marque;
    String modele;

    void demarrer() {
        System.out.println("La voiture " + marque + " " + modele + " démarre.");
    }

    void accelerer() {
        System.out.println("La voiture " + marque + " " + modele + " accélère.");
    }

    void freiner() {
        System.out.println("La voiture " + marque + " " + modele + " freine.");
    }
}

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
