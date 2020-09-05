package hackerrank.practice.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int start = 0;
        int i = 0;
        int max = 0;
        while (i < a.size()) {
            if (Math.abs(a.get(start) - a.get(i)) > 1) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
            i++;
        }
        i--;

        return Math.max(max, i - start + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = pickingNumbers(a);
        bufferedReader.close();
    }
}
