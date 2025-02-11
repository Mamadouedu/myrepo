public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture(
            "Rouge", 
            "Toyota", 
            "Corolla");

        voiture.demarrer();
        voiture.accelerer();
        voiture.freiner();
    }
}