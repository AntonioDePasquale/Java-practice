import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
        String line;

        // Variable to store the closest places minimum distance
        int minDistance = Integer.MAX_VALUE;

        while ((line = in.readLine()) != null) {
            // Create a list to store the places and distances
            List<Map.Entry<String, Integer>> placesList = new ArrayList<>();

            //split the line at the semicolon to get an array of "places, distances"
            String[] splitLine = line.split(";");

            for (String place : splitLine) {
                //trim the whitespace from the line
                place = place.trim();
                System.out.println(place + " test");

                //split each place again into the place string and distance at the comma, add each result to a map
                String[] placeAndDistance = place.split(",");

                if (placeAndDistance.length == 2) {
                    String placeName = placeAndDistance[0].trim();
                    int distance;

                    //try catch to make sure that the distance string can be cast into a valid integer
                    try {
                        distance = Integer.parseInt(placeAndDistance[1].trim());

                        // Update the closest place if the distance value is lower than minDistance
                        if (distance < minDistance) {
                            minDistance = distance;
                        }

                        // Add each place and distance to the list
                        placesList.add(new AbstractMap.SimpleEntry<>(placeName, distance));

                    } catch (NumberFormatException e) {
                        System.err.println("input for the distance is not a valid number format: " + placeAndDistance[1].trim());
                    }
                } else {
                    System.err.println("input does not follow the required format: " + place);
                }
            }

            // Sort the list by distance
            placesList.sort(Comparator.comparingInt(Map.Entry::getValue));

            //compares two indexs of the placesList against one another and returns the distance difference, then add to a new ArrayList
            List<Integer> differences = new ArrayList<>();
            for (int i = 0; i < placesList.size() - 1; i++) {
                int currentDistance = placesList.get(i).getValue();
                int nextDistance = placesList.get(i + 1).getValue();
                int difference = nextDistance - currentDistance;
                differences.add(difference);
            }

            //Builds a string of the values in the differences ArrayList separated by commas
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < differences.size(); i++) {
                result.append(differences.get(i));
                if (i < differences.size() - 1) {
                    result.append(",");
                }
            }
            //add the minDistance to the start of the string, return the result
            result = new StringBuilder((minDistance + "," + result));
            System.out.println(result);
        }
    }
}
