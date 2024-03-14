import java.util.Arrays;
import java.util.Scanner;

public class Main {

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

        TestCapital(); // Test single capital
        PrintArray(states_and_captials); // Print array
        // BubbleSort(states_and_captials); // Sort Array
        PrintArray(states_and_captials); // Print array
        TestCapitals(); // Test all capitals
        PrintResults(); // Print results
    }

    public static void TestCapital() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*Answers are not case-sensitive.");
        System.out.println("Enter a United States capital: ");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println("The capital entered: " + input.toLowerCase());

        System.out.println("The value entered does not match a United States capital.");
        System.out.println("The value entered matches a United States capital.");
    }

    public static void TestCapitals() {
        // for
        System.out.println("What is the capital of the the state: " + "state_variable" + " ?");
    }

    public static void PrintResults() {
        System.out.println("The total ");
    }

    public static void PrintArray(String[][] list) {
        for (String[] item : list) {
            System.out.println(Arrays.toString(item));
        }
    }

    public static boolean isValidState(String state, String Capital) {
        return false;
    }

    public static boolean isValidCapital(String state, String Capital) {
        return false;
    }
}

// private static int[] BubbleSort(int[] list, int length) {
// boolean swap = true;
// int temp;
// while (swap) {
// swap = false;
// for (int i = 0; i < list.length - 1; i++) {
// if (list[i] > list[i + 1]) {
// temp = list[i];
// list[i] = list[i + 1];
// list[i + 1] = temp;
// swap = true;
// }
// }
// }
// return list;
// }

// String[][] test = {
// { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
// "Connecticut", "Delaware",
// "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
// "Kansas", "Kentucky",
// "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
// "Mississippi",
// "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
// "New Mexico",
// "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
// "Pennsylvania",
// "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
// "Utah", "Vermont",
// "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" },
// { "Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver",
// "Hartford", "Dover",
// "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis",
// "Des Moines",
// "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston",
// "Lansing", "St. Paul",
// "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord",
// "Trenton",
// "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City",
// "Salem", "Harrisburg",
// "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City",
// "Montpelier",
// "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne" }
// };
