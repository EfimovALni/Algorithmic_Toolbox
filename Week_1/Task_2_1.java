import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Task_2_1 {

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
        int max = 13;
        int min = 2;
        int step = 0;

        while (true) {
            int sizeOfVector = (int) ((Math.random() * (max - min)) + min);         // Generate & calculate numbers of interval [2..13]

//        Generate vector
            Vector<Long> vector = new Vector<>(sizeOfVector);                        // Create 'Vector' instead of array
            for (int i = 0; i < sizeOfVector; i++) {
                vector.add(ThreadLocalRandom.current().nextLong(0, 100_000));        // Filling vector pseudo-random numbers
            }

            System.out.println("Size of array: " + sizeOfVector + ",\t" + vector);   // Display to console

            long result_1 = MaxPairwiseProduct(sizeOfVector, vector);
            long result_2 = MaxPairwiseProductFast(sizeOfVector, vector);

            System.out.println("№: " + step + "|\tFunc._1 = " + result_1 + "\t\tFunc._2 = " + result_2);

            if (result_1 != result_2) {
                System.err.println("Wrong answer: " + result_1 + " & " + result_2);
                break;
            } else {
                System.out.println("ok");
            }
            step += 1;
        }

    }
}
