package hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int max = 0;
        int[] countArray = new int[arr.size() + 1];
        for (int val : arr) {
            countArray[val]++;
            max = Math.max(max, countArray[val]);
        }
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == max) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = migratoryBirds(arr);
        bufferedReader.close();
    }
}
