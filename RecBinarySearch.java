import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
* The rec Binary program generates 250 random numbers in an
* array and allows the user to search for a number in the array.
*
* @author Ketia Gaelle Kaze
* @version 1.0
* @since 2022-04-05
*/

class RecBinarySearch {
    /**
    * The min number for array.
    */
    public static final int MIN = 0;
    /**
    * The max number for array.
    */
    public static final int MAX = 999;
    /**
    * The number of elements in the array.
    */
    public static final int ARRAY_SIZE = 250;

    /**
    * Creating an empty constructor.
    */
    RecBinarySearch() { }

    /**
    * Creating function to find the index of a number,
    * using Binary Search recursively.
    *
    * @param userArray as array
    * @param userNumber as int
    * @param lowIndex as int
    * @param highIndex as int
    *
    * @return index as int
    */
    public int binary(int[] userArray, int userNumber,
            int lowIndex, int highIndex) {

        // Get the middle index of the array
        int midIndex = (lowIndex + highIndex) / 2;

        if (lowIndex > highIndex) {
            return -1;
        }

        // Check if the userNumber is at the middle
        if (userArray[midIndex] == userNumber) {
            return midIndex;

        } else if (userArray[midIndex] > userNumber) {
            return binary(userArray, userNumber, lowIndex, midIndex - 1);

        } else if (userArray[midIndex] < userNumber) {
            return binary(userArray, userNumber, midIndex + 1, highIndex);
        }

        return -1;
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(final String[] args) {
        // Declaring variables
        Scanner sc = new Scanner(System.in);
        int counter;
        String numberString;
        int searchNum;
        int searchResult;

        // Create a binary search object
        RecBinarySearch binarySearch = new RecBinarySearch();

        // Initializing the random class
        Random randNumber = new Random();

        // Initializing array of numbers
        int[] randomNumberArray = new int[ARRAY_SIZE];

        // Adding numbers to the array
        for (counter = 0; counter < randomNumberArray.length; counter++) {
            randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
        }

        // Sorting the array
        int[] numberArray = randomNumberArray;
        Arrays.sort(numberArray);

        System.out.println(Arrays.toString(numberArray));
        System.out.println("\n");

        System.out.print("What number are you searching for "
            + "in the array (integer between 0 and 999): ");
        numberString = sc.nextLine();
        try {
            searchNum = Integer.parseInt(numberString);

            // Ensuring the user inputs an appropriate integer
            if (searchNum > MAX || searchNum < MIN) {
                System.out.println(searchNum + " must be between "
                    + MIN + " and " + MAX + ".\n");
            } else {
                // Using binary search to find the user's
                // chosen number in the array
                searchResult = binarySearch.binary(numberArray, searchNum,
                    0, numberArray.length - 1);

                if (searchResult == -1) {
                    System.out.println("\n" + searchNum
                        + " is not in the array.");

                } else {
                    // Display the results of the search
                    System.out.println("\n" + searchNum
                        + " is at index: " + searchResult + ".");

                }
            }
        } catch (Exception exception) {
            // Error message if input isn't a number
            System.out.println("Please enter a valid number.\n");
        }
    }
}
