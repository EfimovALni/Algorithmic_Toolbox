import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Task_2_1 {
    //    Method which get size of vector and generate vector.
    public static Vector<Long> VectorOur(int sizeOfVector) {
        Vector<Long> vector = new Vector<>(sizeOfVector);                        // Create 'Vector' instead of array
        for (int i = 0; i < sizeOfVector; i++) {
            vector.add(ThreadLocalRandom.current().nextLong(0, 10_00_000_000));        // Filling vector pseudo-random numbers, 'bound' - max number
        }
        return vector;
    }

    //  Method '1' which get size of vector and vector & find two maximum numbers
    public static long MaxPairwiseProduct(int sizeOfVector, Vector<Long> vector) {
        long result = 0;
        long max_1 = 0;
        long max_2 = 0;

        for (int i = 0; i < sizeOfVector; i++) {
            for (int j = i + 1; j < sizeOfVector; j++) {
                max_1 = vector.get(i);
                if (vector.get(i) != vector.get(j) && (vector.get(j) != max_1)) {
                    long tempResult = vector.get(i) * vector.get(j);                // Find two maximum numbers by multiplying
                    if (tempResult > result) {
                        result = tempResult;
                    }
                }
            }
        }
        return result;
    }

    //  Method '2' which get size of vector and vector & find two maximum numbers
    public static long MaxPairwiseProductFast(int sizeOfVector, Vector<Long> vector) {
        long max_1 = 0;
        long max_2 = 0;

//        Find first maximum number
        for (int i = 0; i < sizeOfVector; i++) {
            if (vector.get(i) > max_1) {
                max_1 = vector.get(i);
            }
        }

//        Find second maximum number
        for (int i = 0; i < sizeOfVector; i++) {
            if ((vector.get(i) != max_1) && (vector.get(i) > max_2)) {
                max_2 = vector.get(i);
            }
        }
        return max_2 * max_1;
    }


    public static void main(String[] args) {
        //  *** Manual input data start *** ----------> for using 'Stress test', need to comment this block of code!!!

         Scanner scanner = new Scanner(System.in);
         int sizeOfVector = scanner.nextInt();               // Generate size of vector

        Vector<Long> vectorManual = new Vector<Long>();

        //  Filling the vector
        Scanner numbersOfVector = new Scanner(System.in);
        for (int i = 0; i < sizeOfVector; i++) {
            vectorManual.add(numbersOfVector.nextLong());
        }

        scanner.close();
        numbersOfVector.close();


         long result_1 = MaxPairwiseProduct(sizeOfVector, vectorManual);
        long result_2 = MaxPairwiseProductFast(sizeOfVector, vectorManual);


         System.out.println("Func._1 = " + result_1 + "\t\tFunc._2 = " + result_2);   // For output solution of two 'Methods'
        System.out.println(result_2);
        //  *** Manual input data end ***


        //        Stress-test, for using uncomment this block  of code!
        /**
        //  *** Stress test start ***
        int max = 1_000;  // Max length of vector
        int min = 2;        // Min length of vector
        int step = 0;

        while (true) {
            int sizeOfVector = (int) ((Math.random() * (max - min)) + min);         // Generate & calculate numbers of interval [2..13]

            Vector<Long> vectorManual = (Vector<Long>) VectorOur(sizeOfVector);

            System.out.println("Size of array: " + sizeOfVector + ",\t" + vectorManual);   // Display to console

            long result_1 = MaxPairwiseProduct(sizeOfVector, vectorManual);
            long result_2 = MaxPairwiseProductFast(sizeOfVector, vectorManual);

            System.out.println("№: " + step + "|\tFunc._1 = " + result_1 + "\t\tFunc._2 = " + result_2);

            if (result_1 != result_2) {
                System.err.println("Wrong answer: " + result_1 + " & " + result_2);
                break;
            } else {
                System.out.println("ok");
            }
            step += 1;
        }
        //  *** Stress test finish! ***
        */
    }
}
