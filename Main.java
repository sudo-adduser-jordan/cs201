import java.security.DrbgParameters.Reseed;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// Add actual java comments

public class Main {

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
                { "Alabama", "Montgomery" },
                { "Alaska", "Juneau" },
                { "Arizona", "Phoenix" },
                { "Arkansas", "Little Rock" },
                { "California", "Sacramento" },
                { "Colorado", "Denver" },
                { "Connecticut", "Hartford" },
                { "Delaware", "Dover" },
                { "Florida", "Tallahassee" },
                { "Georgia", "Atlanta" },
                { "Hawaii", "Honolulu" },
                { "Idaho", "Boise" },
                { "Illinois", "Springfield" },
                { "Indiana", "Indianapolis" },
                { "Iowa", "Des Moines" },
                { "Kansas", "Topeka" },
                { "Kentucky", "Frankfort" },
                { "Louisiana", "Baton Rouge" },
                { "Maine", "Augusta" },
                { "Maryland", "Annapolis" },
                { "Massachusetts", "Boston" },
                { "Michigan", "Lansing" },
                { "Minnesota", "Saint Paul" },
                { "Mississippi", "Jackson" },
                { "Missouri", "Jefferson City" },
                { "Montana", "Helena" },
                { "Nebraska", "Lincoln" },
                { "Nevada", "Carson City" },
                { "New Hampshire", "Concord" },
                { "New Jersey", "Trenton" },
                { "New Mexico", "Santa Fe" },
                { "New York", "Albany" },
                { "North Carolina", "Raleigh" },
                { "North Dakota", "Bismarck" },
                { "Ohio", "Columbus" },
                { "Oklahoma", "Oklahoma City" },
                { "Oregon", "Salem" },
                { "Pennsylvania", "Harrisburg" },
                { "Rhode Island", "Providence" },
                { "South Carolina", "Columbia" },
                { "South Dakota", "Pierre" },
                { "Tennessee", "Nashville" },
                { "Texas", "Austin" },
                { "Utah", "Salt Lake City" },
                { "Vermont", "Montpelier" },
                { "Virginia", "Richmond" },
                { "Washington", "Olympia" },
                { "West Virginia", "Charleston" },
                { "Wisconsin", "Madison" },
                { "Wyoming", "Cheyenne" }
        };

        // partOne(states_and_captials);
        partTwo(states_and_captials);
    }

    private static void partTwo(String[][] states_and_captials) {
        System.out.println("\n" + GREEN + "HashMap: " + RESET);
        HashMap<String, String> hashMap = new HashMap<String, String>(states_and_captials.length);
        for (String[] row : states_and_captials) {
            hashMap.put(row[0], row[1]);
        }
        prettyPrintHashMap(hashMap, false);

        System.out.println("\n" + GREEN + "TreeMap: " + RESET);
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(hashMap);
        prettyPrintHashMap(treeMap, false);
    }

    public static void partOne(String[][] states_and_captials) {
        System.out.println("\n" + GREEN + "Initial Array: " + RESET);
        prettyPrintArray2D(states_and_captials, false);

        bubbleSort(states_and_captials);

        System.out.println("\n" + GREEN + "Bubble Sorted Array: " + RESET);
        prettyPrintArray2D(states_and_captials, true);

        testCapitals(states_and_captials);
    }

    private static void printMatch(Map<String, String> map) {
        Scanner scanner = new Scanner(System.in);
        Integer total = 0;

        System.out.println(YELLOW + "\n**Answers are NOT case sensitive." + RESET);
        for (String[] array : states_and_captials) {
            System.out.print("\nEnter the capital of " + YELLOW + array[0] + RESET + ": ");
            String answer = scanner.nextLine().toLowerCase().trim();
            if (answer.matches(array[1].toLowerCase())) {
                total = total + 1;
            }
        }
        scanner.close();

        System.out.println("\nTotal correct answers: " + total + " / 50");
    }

    private static void testCapitals(Map<String, String> map) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();

        System.out.println(YELLOW + "\n**Input is NOT case sensitive." + RESET);
        System.out.print("\nEnter a state: ");
        String state = scanner.nextLine().toLowerCase().trim();

        // serach treemap binary tree storage

        System.out.println("The capital of " + GREEN + state + RESET + " is " + GREEN + "capital_of_state" + RESET);
    }

    private static void bubbleSort(String[][] array2D) {
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

    private static void prettyPrintHashMap(Map<String, String> map, boolean isSorted) {
        String STATE_COLOR = GREEN;
        String CAPITAL_COLOR = YELLOW;

        if (isSorted) {
            STATE_COLOR = YELLOW;
            CAPITAL_COLOR = GREEN;
        }

        System.out.println("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String state = entry.getKey();
            String capital = entry.getValue();

            String stringOne = "\t"
                    + "{ "
                    + STATE_COLOR
                    + state
                    + RESET
                    + "\t\t";

            String stringTwo = CAPITAL_COLOR
                    + capital
                    + RESET
                    + "\t},";

            if (capital.length() <= 7) {
                stringTwo = CAPITAL_COLOR
                        + capital
                        + RESET
                        + "\t\t},";
            }

            if (state.length() < 6) {
                stringOne = "\t"
                        + "{ "
                        + STATE_COLOR
                        + state
                        + RESET
                        + "\t\t\t";
            }
            if (state.length() > 13) {
                stringOne = "\t"
                        + "{ "
                        + STATE_COLOR
                        + state
                        + RESET
                        + "\t";
            }

            System.out.println(stringOne + stringTwo);
        }
        System.out.println("}");
    }

    private static void prettyPrintArray2D(String[][] array2D, boolean isSorted) {
        String STATE_COLOR = GREEN;
        String CAPITAL_COLOR = YELLOW;

        if (isSorted) {
            STATE_COLOR = YELLOW;
            CAPITAL_COLOR = GREEN;
        }

        System.out.println("[");
        for (String[] array : array2D) {
            String stringOne = "\t"
                    + "[ "
                    + STATE_COLOR
                    + array[0]
                    + RESET
                    + "\t\t";

            String stringTwo = CAPITAL_COLOR
                    + array[1]
                    + RESET
                    + "\t]";

            if (array[1].length() <= 7) {
                stringTwo = CAPITAL_COLOR
                        + array[1]
                        + RESET
                        + "\t\t]";
            }

            if (array[0].length() < 6) {
                stringOne = "\t"
                        + "[ "
                        + STATE_COLOR
                        + array[0]
                        + RESET
                        + "\t\t\t";
            }
            if (array[0].length() > 13) {
                stringOne = "\t"
                        + "[ "
                        + STATE_COLOR
                        + array[0]
                        + RESET
                        + "\t";
            }

            System.out.println(stringOne + stringTwo);
        }
        System.out.println("]");
    }

}
