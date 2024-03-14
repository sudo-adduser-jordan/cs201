import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // For the reviewer if this code gets executed.

    // ANSI COLOR Codes
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        String[][] states_and_captials = {
                { "alabama", "montgomery" },
                { "alaska", "juneau" },
                { "arizona", "phoenix" },
                { "arkansas", "little rock" },
                { "california", "sacramento" },
                { "colorado", "denver" },
                { "connecticut", "hartford" },
                { "delaware", "dover" },
                { "florida", "tallahassee" },
                { "georgia", "atlanta" },
                { "hawaii", "honolulu" },
                { "idaho", "boise" },
                { "illinois", "springfield" },
                { "indiana", "indianapolis" },
                { "iowa", "des moines" },
                { "kansas", "topeka" },
                { "kentucky", "frankfort" },
                { "louisiana", "baton rouge" },
                { "maine", "augusta" },
                { "maryland", "annapolis" },
                { "massachusetts", "boston" },
                { "michigan", "lansing" },
                { "minnesota", "saint paul" },
                { "mississippi", "jackson" },
                { "missouri", "jefferson city" },
                { "montana", "helena" },
                { "nebraska", "lincoln" },
                { "nevada", "carson city" },
                { "new hampshire", "concord" },
                { "new jersey", "trenton" },
                { "new mexico", "santa fe" },
                { "new york", "albany" },
                { "north carolina", "raleigh" },
                { "north dakota", "bismarck" },
                { "ohio", "columbus" },
                { "oklahoma", "oklahoma city" },
                { "oregon", "salem" },
                { "pennsylvania", "harrisburg" },
                { "rhode island", "providence" },
                { "south carolina", "columbia" },
                { "south dakota", "pierre" },
                { "tennessee", "nashville" },
                { "texas", "austin" },
                { "utah", "salt lake city" },
                { "vermont", "montpelier" },
                { "virginia", "richmond" },
                { "washington", "olympia" },
                { "west virginia", "charleston" },
                { "wisconsin", "madison" },
                { "wyoming", "cheyenne" }
        };
        // Integer total = 0;

        System.out.println(GREEN + "Initial Array: " + RESET);
        // printArray2D(states_and_captials);
        prettyPrintArray2D(states_and_captials);

        bubbleSort(states_and_captials);

        System.out.println(GREEN + "Bubble Sorted Array: " + RESET);
        // printArray2D(states_and_captials);
        prettyPrintArray2D(states_and_captials);
        // TestCapitals(); // Test all capitals
        // PrintResults(); // Print results
    }

    public static void bubbleSort(String[][] array2D) {
        int len = array2D.length;
        boolean swapped;
        do {
            swapped = false;
            for (int row = 1; row < len; row++) { // Compare the capital (second element) of the current element with
                                                  // the capital of the previous element
                if (array2D[row - 1][1].compareToIgnoreCase(array2D[row][1]) > 0) { // If the current element is smaller
                                                                                    // than the previous element, swap
                                                                                    // them
                    String[] temp = array2D[row - 1];
                    array2D[row - 1] = array2D[row];
                    array2D[row] = temp;
                    swapped = true; // Indicates that a swap occurred in this pass
                }
            }
        } while (swapped); // Continue iterating and swapping until no more swaps are needed
    }

    public static void prettyPrintArray2D(String[][] array2D) {
        System.out.println("[");
        for (String[] array : array2D) {

            String stringOne = "\t"
                    + "[ "
                    + YELLOW
                    + array[0]
                    + RESET
                    + "\t\t";

            String stringTwo = GREEN
                    + array[1]
                    + RESET
                    + "\t]";

            if (array[1].length() <= 7) {
                stringTwo = GREEN
                        + array[1]
                        + RESET
                        + "\t\t]";
            }

            if (array[0].length() < 6) {
                stringOne = "\t"
                        + "[ "
                        + YELLOW
                        + array[0]
                        + RESET
                        + "\t\t\t";
            }
            if (array[0].length() > 13) {
                stringOne = "\t"
                        + "[ "
                        + YELLOW
                        + array[0]
                        + RESET
                        + "\t";
            }

            System.out.println(stringOne + stringTwo);
        }
        System.out.println("]");
    }

    public static boolean isValidState(String state, String Capital) {
        return false;
    }

    public static boolean isValidCapital(String state, String Capital) {
        return false;
    }

}