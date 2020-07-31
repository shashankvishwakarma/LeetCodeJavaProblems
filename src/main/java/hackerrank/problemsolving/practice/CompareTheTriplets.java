package hackerrank.problemsolving.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class CompareTheTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int pointsAlice = 0, pointsBob = 0;

        pointsAlice = (a.get(0) > b.get(0) ? 1 : 0) + (a.get(1) > b.get(1) ? 1 : 0) + (a.get(2) > b.get(2) ? 1 : 0);
        pointsBob = (a.get(0) < b.get(0) ? 1 : 0) + (a.get(1) < b.get(1) ? 1 : 0) + (a.get(2) < b.get(2) ? 1 : 0);

        return Arrays.asList(pointsAlice, pointsBob);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);
        System.out.println(result);
    }
}
