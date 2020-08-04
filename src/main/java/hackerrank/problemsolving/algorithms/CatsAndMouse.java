package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class CatsAndMouse {
    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        int diffA = Math.abs(x - z); //Distance Cat A is from Mouse
        int diffB = Math.abs(y - z); //Distance Cat B is from Mouse
        if (diffA < diffB)
            return "Cat A";
        else if (diffB < diffA)
            return "Cat B";
        else
            return "Mouse C";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);
        }
        scanner.close();
    }
}
