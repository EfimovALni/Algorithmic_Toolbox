import java.util.Scanner;

//Solving the Maximum Pairwise Product Programming Challenge: Improving the Naive Solution, Testing, Debugging

public class Task_2 {
    public static long multiplyTwoNumbers(long max1, long max2) {
        return max1 * max2;
    }

    public static void main(String[] args) {
//        Enter length of array
        Scanner scLengthOfArray = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int lengthOfArray = scLengthOfArray.nextInt();

//        Reading line of numbers for array
        Scanner scLineOfNumbers = new Scanner(System.in);
        System.out.println("Enter the line of numbers through the space: ");
        String stringNumbers = scLineOfNumbers.nextLine();

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
    }
}
