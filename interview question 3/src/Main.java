import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestClass {

    private static final Logger logger = Logger.getLogger(TestClass.class.getName());

    public static void main(String[] args) {
        try {
            // Create a new instance of the class
            TestClass testClass = new TestClass();

            // Call the method and get the result
            double total = testClass.widgets();

            // Print the result
            System.out.println("Total cost: $" + total);
        } catch (IOException e) {
            // Log the exception
            logger.log(Level.SEVERE, "An IOException occurred", e);
        }
    }

    private double widgets() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of items: ");
        String name = br.readLine();

        double total;
        try {
            // Convert the string which is an int into an integer
            int num = Integer.parseInt(name);

            // Constants for pricing
            final double PRICE_PER_ITEM = 0.65;
            final double DISCOUNTED_PRICE_FOR_3_ITEMS = 1.00;

            // Calculate the total cost based on the number of items
            if (num < 3) {
                total = num * PRICE_PER_ITEM;
            } else {
                // Calculate the cost with discount for every 3 items
                int discountedSets = num / 3;
                int remainingItems = num % 3;
                total = discountedSets * DISCOUNTED_PRICE_FOR_3_ITEMS + remainingItems * PRICE_PER_ITEM;
            }
        } catch (NumberFormatException e) {
            // Log the number format exception
            logger.log(Level.WARNING, "Invalid number format: " + name, e);
            // Handle the exception or rethrow it
            throw new IOException("Invalid input format", e);
        }

        return total;
    }
}