import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Task_2_1 {

//    public static Vector<Long> Vector(int sizeOfVector) {
//        Vector<Long> vector = new Vector<>(sizeOfVector);                        // Create 'Vector' instead of array
//        for (int i = 0; i < sizeOfVector; i++) {
//            vector.add(ThreadLocalRandom.current().nextLong(1_0));        // Filling vector pseudo-random numbers
//        }
//        return vector;
//    }

    public static long MaxPairwiseProduct(int sizeOfVector, Vector<Long> vector) {
        long result = 0;

//        Vector<Long> vector = new Vector<>(sizeOfVector);                        // Create 'Vector' instead of array
//        for (int i = 0; i < sizeOfVector; i++) {
//            vector.add(ThreadLocalRandom.current().nextLong(1_0));        // Filling vector pseudo-random numbers
//        }

        System.out.println("Size of array: " + sizeOfVector + "\t" + vector);   // Display to console

        for (int i = 0; i < sizeOfVector; i++) {
            for (int j = i + 1; j < sizeOfVector; j++) {
                long tempResult = vector.get(i) * vector.get(j);                // Find two maximum numbers by multiplying
                if (tempResult > result) {
                    result = tempResult;
                }
            }
        }
        return result;
    }


    public static long MaxPairwiseProductFast(int sizeOfVector, Vector<Long> vector) {
        int maxIndex_1 = 0;
        int maxIndex_2 = 0;

        System.out.println("Size of array: " + sizeOfVector + "\t" + vector);   // Display to console

//        Find first maximum number
        for (int i = 0; i < sizeOfVector; i++) {
            if (vector.get(i) > maxIndex_1) {
                maxIndex_1 = Math.toIntExact(vector.get(i));
            }
        }

//        Find second maximum number
        for (int i = 0; i < sizeOfVector; i++) {
            if ((vector.get(i) > maxIndex_2) && (vector.get(i) != maxIndex_1)) {
                maxIndex_2 = Math.toIntExact(vector.get(i));
            }
        }
        return maxIndex_2 * maxIndex_1 ;
    }


    public static void main(String[] args) {
        Random sizeOfVectorGenerate = new Random();
        int sizeOfVector = sizeOfVectorGenerate.nextInt(13);

//        Generate vector
        Vector<Long> vector = new Vector<>(sizeOfVector);                        // Create 'Vector' instead of array
        for (int i = 0; i < sizeOfVector; i++) {
            vector.add(ThreadLocalRandom.current().nextLong(1_0));        // Filling vector pseudo-random numbers
        }


        System.out.println("Maximum two numbers from 'Function' 1:\t" + MaxPairwiseProduct(sizeOfVector, vector));
        System.out.println("Maximum two numbers from 'Function' 2:\t" + MaxPairwiseProductFast(sizeOfVector, vector));

    }
}
