import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Here we take Task 2 and added some automatic test
// Solving the Maximum Pairwise Product Programming Challenge: Improving the Naive Solution, Testing, Debugging

public class Task_3 {
    public static long multiplyTwoNumbers(long max1, long max2) {
        return max1 * max2;
    }

    public static void main(String[] args) {
//        Enter length of array
        /*Scanner scLengthOfArray = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int lengthOfArray = scLengthOfArray.nextInt();*/

        Random randomLengthOfArray = new Random();
        Random randomStringNumbers = new Random();

        for (int i = 0; i < 4; i++) {       // Generate size of number array
            int lengthOfArray = randomLengthOfArray.nextInt(13) + 2;
            System.out.println("Size of array: " + lengthOfArray);

            long[] arrayClean = new long[lengthOfArray];
//            Generate array
            for (int j = 0; j < lengthOfArray; j++) {
//                long stringNumbers = Math.abs(randomStringNumbers.nextLong());
                long stringNumbers = ThreadLocalRandom.current().nextLong(1_000_000);
                System.out.print(stringNumbers + " ");
                arrayClean[j] = stringNumbers;
            }
            System.out.println();

            for (int j = 0; j < lengthOfArray; j++) {
                System.out.print(arrayClean[j] + ", ");
            }
            System.out.println();

            long max_1 = 0;
            int indexMax_1 = 0;
            long max_2 = 0;
            int indexMax_2 = 0;

//        Find first maximum number
            for (int j = 0; j < lengthOfArray; j++) {
                if (arrayClean[j] > max_1) {
                    max_1 = arrayClean[j];
                    indexMax_1 = j;
                }
            }

//        Find second maximum number
            for (int j = 0; j < lengthOfArray; j++) {
                if ((arrayClean[j] > max_2) && (arrayClean[j] != max_1)) {
                    max_2 = arrayClean[j];
                    indexMax_2 = j;
                }
            }
            System.out.println("Pos.: " + indexMax_1 + "\tnumb.: " + max_1);
            System.out.println("Pos.: " + indexMax_2 + "\tnumb.: " + max_2);
            System.out.println("Max_1 * Max_2 = " + multiplyTwoNumbers(max_1, max_2));
            System.out.println();

        }

/**

 //        Filing the array
 String[] numbers = stringNumbers.trim().replaceAll("( )+", " ").split("\\s");
 int[] arrayClean = new int[lengthOfArray];

 for (int i = 0; i < lengthOfArray; i++) {
 arrayClean[i] = Integer.parseInt(numbers[i]);
 }

 //        Only for testing
 //        for (int i = 0; i < arrayClean.length; i++) {
 //            System.out.print(arrayClean[i] + "\t");
 //        }
 //        System.out.println();

 int max_1 = 0;
 int indexMax_1 = 0;
 int max_2 = 0;
 int indexMax_2 = 0;
 //        Find first maximum number
 for (int i = 0; i < arrayClean.length; i++) {
 if (arrayClean[i] > max_1) {
 max_1 = arrayClean[i];
 indexMax_1 = i;
 }
 }
 //        Find first maximum number
 for (int i = 0; i < arrayClean.length; i++) {
 if ((arrayClean[i] > max_2) && arrayClean[i] != max_1) {
 max_2 = arrayClean[i];
 indexMax_2 = i;
 }
 }
 System.out.println("Pos.: " + indexMax_1 + "\tnumb.: " + max_1);
 System.out.println("Pos.: " + indexMax_2 + "\tnumb.: " + max_2);

 System.out.println(multiplyTwoNumbers(max_1, max_2));

 */
    }
}
