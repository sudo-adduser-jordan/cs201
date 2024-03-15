import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

// Computer Science 201 - Assignment 1: Array Sorting and Hashmaps

public class Main {

    // ANSI COLOR Codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";

    // States and Capitals 2D array
    private static String[][] statesAndCapitals = {
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

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        partOne();
        partTwo();
        scanner.close();
    }

    // Part 1: Sorting Arrays
    private static void partOne() {
        System.out.println("\n" + GREEN + "Initial array sorted by state: " + RESET);
        prettyPrintArray2D(statesAndCapitals, false);

        bubbleSort(statesAndCapitals);

        System.out.println("\n" + GREEN + "Bubble sorted array by capital: " + RESET);
        prettyPrintArray2D(statesAndCapitals, true);

        testCapitals(statesAndCapitals);
    }

    // Test user on all 50 capitals
    private static void testCapitals(String[][] statesAndCapitals) {
        Integer total = 0;

        System.out.println(YELLOW + "\n**Answers are NOT case sensitive." + RESET);
        for (String[] row : statesAndCapitals) {
            System.out.print("\nEnter the capital of " + YELLOW + row[0] + RESET + ": ");
            String answer = scanner.nextLine().toLowerCase().trim();
            if (answer.matches(row[1].toLowerCase())) {
                total = total + 1;
            }
        }

        System.out.println("\nTotal correct answers: " + total + " / 50");
    }

    // Part 2: Sorting & Searching HashMap
    private static void partTwo() {
        System.out.println("\n" + GREEN + "HashMap: " + RESET);
        HashMap<String, String> hashMap = new HashMap<String, String>(statesAndCapitals.length);
        for (String[] row : statesAndCapitals) {
            hashMap.put(row[0], row[1]);
        }
        prettyPrintMap(hashMap, false);

        System.out.println("\n" + GREEN + "TreeMap sorted by key: " + RESET);
        TreeMap<String, String> treeMap = new TreeMap<String, String>(); // "then use the TreeMap class to sort the map
                                                                         // while using a binary search tree for
                                                                         // storage"
        treeMap.putAll(hashMap);
        prettyPrintMap(treeMap, true);

        findCaptial(treeMap);
    }

    // Find state and display capital
    private static void findCaptial(Map<String, String> sortedMap) {
        System.out.println(YELLOW + "\n**Input is NOT case sensitive." + RESET);
        System.out.print("\nEnter a state: ");

        String input = scanner.nextLine().toLowerCase().trim();

        if (input.length() == 0) {
            System.out.println(RED + "Capital not found for the state entered. \n" + RESET);
            return;
        }

        String state = Arrays.stream(input // Capitalize Input
                .split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));

        String capital = sortedMap.get(state);
        if (capital != null) {
            System.out.println("The capital of " + GREEN + state + RESET + " is " + GREEN + capital + RESET + "\n");
        } else {
            System.out.println(RED + "Capital not found for the state entered. \n" + RESET);
        }
    }

    // BubbleSort 2D array of strings
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

    // Pretty print map
    private static void prettyPrintMap(Map<String, String> map, boolean isSorted) {
        String STATE_COLOR = YELLOW;
        String CAPITAL_COLOR = YELLOW;

        if (isSorted) {
            STATE_COLOR = GREEN;
            CAPITAL_COLOR = YELLOW;
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

    // Pretty print 2D array of strings
    private static void prettyPrintArray2D(String[][] array2D, boolean isSorted) {
        String STATE_COLOR = GREEN;
        String CAPITAL_COLOR = YELLOW;

        if (isSorted) {
            STATE_COLOR = YELLOW;
            CAPITAL_COLOR = GREEN;
        }

        System.out.println("[");
        for (String[] array : array2D) {
            String state = array[0];
            String capital = array[1];

            String stringOne = "\t" + "[ "
                    + STATE_COLOR
                    + state
                    + RESET
                    + "\t\t";

            String stringTwo = CAPITAL_COLOR
                    + capital
                    + RESET
                    + "\t]";

            if (capital.length() <= 7) {
                stringTwo = CAPITAL_COLOR
                        + capital
                        + RESET
                        + "\t\t]";
            }
            if (state.length() < 6) {
                stringOne = "\t"
                        + "[ "
                        + STATE_COLOR
                        + state
                        + RESET
                        + "\t\t\t";
            }
            if (state.length() > 13) {
                stringOne = "\t"
                        + "[ "
                        + STATE_COLOR
                        + state
                        + RESET
                        + "\t";
            }

            System.out.println(stringOne + stringTwo);
        }
        System.out.println("]");
    }
}
