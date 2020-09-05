package hackerrank.practice.algorithms.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        List<Integer> list = Arrays.stream(arr)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());

        long min = list.stream().mapToLong(f -> f).min().getAsLong();
        long max = list.stream().mapToLong(f -> f).max().getAsLong();
        long sum = list.stream().mapToLong(f -> f).sum();
        System.out.println((sum - max) + " " + (sum - min));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
