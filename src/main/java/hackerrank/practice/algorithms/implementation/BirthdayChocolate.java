package hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BirthdayChocolate {
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int[] sums = new int[s.size() + 1];
        int count = 0;

        for (int i = 0; i < s.size(); i++) {

            int sumsIndex = i + 1;
            sums[sumsIndex] = sums[sumsIndex - 1] + s.get(i);

            if (sumsIndex >= m && (sums[sumsIndex] - sums[sumsIndex - m]) == d)
                count++;
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);
    }
}

