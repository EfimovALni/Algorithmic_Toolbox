import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Task_1
{
    static int sum(int a, int b) {
        return a + b;
    }
    public static void main(String args[])
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Enter two numbers: ");

        int a = myObj.nextInt();
        int b = myObj.nextInt();

        // System.out.print("'a' + 'b' = " + sum(a, b));
        System.out.println(sum(a, b));

    }
}