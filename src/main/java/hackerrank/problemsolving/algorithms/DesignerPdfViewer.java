package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class DesignerPdfViewer {
    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = 0;
        for (int i = 0; i < word.length(); i++) {
            if (maxHeight < h[word.charAt(i) - 97]) {
                maxHeight = h[word.charAt(i) - 97];
            }
        }
        return word.length() * maxHeight;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();
        int result = designerPdfViewer(h, word);
        scanner.close();
    }
}
