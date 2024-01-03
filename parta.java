import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Part 1: Total Combinations
        int totalCombinations = 6 * 6;
        System.out.println("1. Total Combinations: " + totalCombinations);

        // Part 2: Distribution Matrix
        int[][] distributionMatrix = new int[6][6];

        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                distributionMatrix[i-1][j-1] = i + j;
            }
        }

        // Display the distribution matrix
        System.out.println("\n2. Distribution Matrix:");
        for (int[] row : distributionMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Part 3: Probability of Sums
        int[] sumCounts = new int[12];

        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                sumCounts[i + j - 2]++;
            }
        }

        Map<Integer, Integer> totalOccurrences = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int sum = distributionMatrix[i][j];
                totalOccurrences.put(sum, totalOccurrences.getOrDefault(sum, 0) + 1);
            }
        }

        System.out.println("\nProbability of Possible Sums:");
        for (int sumValue = 2; sumValue <= 12; sumValue++) {
            int occurrences = totalOccurrences.getOrDefault(sumValue, 0);
            double probability = (double) occurrences / totalCombinations;
            System.out.println("Probability sum of " + sumValue + " is " + occurrences + "/" + totalCombinations);
        }
    }
}
