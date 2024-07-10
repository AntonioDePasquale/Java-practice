import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* test input
  6 0 2 4 7 1 8 3 9 5
  A1 3 G DOG 18 3 9 E BIRD ONE 5 U J X2
 */

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line1 = null;
        String line2 = null;

        if ((line1 = in.readLine()) != null && (line2 = in.readLine()) != null) {

            // Convert each line into an arraylist of strings
            List<String> list1 = new ArrayList<>();
            list1.addAll(Arrays.asList(line1.split(" ")));

            List<String> list2 = new ArrayList<>();
            list2.addAll(Arrays.asList(line2.split(" ")));

            // Find the intersection of the two lists
            List<String> matchingChars = findCharsInCommon(list1, list2);

            // Sort the intersection list
            bubbleSortList(matchingChars);

            // Output the result
            if (matchingChars.isEmpty()) {
                System.out.println("NULL");
            } else {
                System.out.println(String.join(" ", matchingChars));
            }
        }
    }

    // Method that compares two lists to find the common characters shared between them
    private static List<String> findCharsInCommon(List<String> list1, List<String> list2) {
        List<String> matchingChars = new ArrayList<>();
        // Use a set to improve lookup times as sets/hashmaps have lookup Big O of O(1)
        Set<String> list2Set = new HashSet<>(list2);

        for (String item : list1) {
            if (list2Set.contains(item)) {
                matchingChars.add(item);
            }
        }
        return matchingChars;
    }

    // Method to sort a list alpha-numerically
    private static void bubbleSortList(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).compareTo(list.get(j)) > 0) {
                    // Swap list[i] and list[j]
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
