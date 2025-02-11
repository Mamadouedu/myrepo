import java.util.Scanner;

public class CompteMotsEtCarac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("jerhferggijrl erlfkjbrogbrjgroig rltgknltiugjngpitg rlkjgbrlgjtrkgjtrrg lkemrkijeriog erkugfruireg  eirufgruy ");
        String texte = scanner.nextLine(); 

        int nombreCaracteres = texte.length();

        String[] mots = texte.trim().split("\\s+");
        int nombreMots = (texte.trim().isEmpty()) ? 0 : mots.length;

        System.out.println("\n🔹 Nombre de caractères : " + nombreCaracteres);
        System.out.println("🔹 Nombre de mots : " + nombreMots);

        scanner.close();
    }
}
