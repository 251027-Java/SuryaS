import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner myReader = new Scanner(System.in);

        // Read a full line of input
        String line = myReader.nextLine();
        String[] parts = line.split(" ");

        int[] responses = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            responses[i] = Integer.parseInt(parts[i]);
        }

        int[] result = countRatings(responses);

        // Print the frequency counts
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(" ");
        }
    }

    public static int[] countRatings(int[] responses) {
        int[] oneToFiveArray = new int[5]; // automatically filled with 0s

        for (int r : responses) {
            if (r >= 1 && r <= 5) {
                oneToFiveArray[r - 1]++;
            }
        }
        return oneToFiveArray;
    }
}
