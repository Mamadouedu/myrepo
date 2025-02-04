
public class TableauStats {
    public static void main(String[] args) {
        int[] data = {3, 5, 7, 2, 8, 10, 11, 1, 6, 4};

        // 🔹 Calcul de la moyenne
        double somme = 0;
        for (int value : data) {
            somme += value;
        }
        double mean = somme / data.length;
        System.out.println("Moyenne: " + mean);

        // 🔹 Calcul de la médiane
        Arrays.sort(data); // Tri du tableau avant de calculer la médiane
        double median;
        if (data.length % 2 == 0) {
            median = (data[data.length / 2] + data[data.length / 2 - 1]) / 2.0;
        } else {
            median = data[data.length / 2];
        }
        System.out.println("Médiane: " + median);

        // 🔹 Calcul de l'écart-type
        double sommeCarres = 0;
        for (int value : data) {
            sommeCarres += Math.pow(value - mean, 2);
        }
        double ecartType = Math.sqrt(sommeCarres / data.length);
        System.out.println("Écart-type: " + ecartType);
    }
}
