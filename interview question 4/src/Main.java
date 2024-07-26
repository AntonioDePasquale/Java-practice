import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyClass {

    private static final Logger logger = Logger.getLogger(MyClass.class.getName());

    public static void main(String[] args) {
        try {
            // Create a new instance of the class
            MyClass myClass = new MyClass();

            // Call the method and get the result
            Integer result = myClass.addNums();

            // Print the result
            System.out.println("Total: " + result);
        } catch (IOException e) {
            // Log the exception
            logger.log(Level.SEVERE, "An IOException occurred", e);
        }
    }

    public Integer addNums() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number: ");
        String name = br.readLine();

        int total = 0;

        // Split the string into an array of substrings
        String[] splitArray = name.split("");  // Changed from "" to " " to split by spaces

        for (String s : splitArray) {
            try {
                // Parse each substring to Integer
                int splitNum = Integer.parseInt(s);
                // Add the parsed number to total
                total += splitNum;
            } catch (NumberFormatException e) {
                // Log the invalid number format
                logger.log(Level.WARNING, "Invalid number format: " + s, e);
            }
        }
        return total; // Return the total sum
    }
}