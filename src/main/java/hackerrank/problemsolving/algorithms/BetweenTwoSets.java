package hackerrank.problemsolving.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class BetweenTwoSetsResult {

    public static int gcdBetweenTwoNumbers(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int getTotalX(List<Integer> firstList, List<Integer> secondList) {
        int lcm = firstList.stream()
                .reduce(firstList.get(0), (a,b) -> a * (b / gcdBetweenTwoNumbers(a, b)));

        int gcd = secondList.stream()
                .reduce(secondList.get(0), (a,b) -> gcdBetweenTwoNumbers(a, b));

        List<Integer> divisors = IntStream.range(1, gcd + 1)
                .filter(number -> gcd % number == 0)
                .boxed()
                .collect(Collectors.toList());

        int cnt = (int) divisors.stream()
                .filter(number -> number % lcm == 0)
                .count();

        System.out.println(cnt);
        return cnt;
    }

}


public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int total = BetweenTwoSetsResult.getTotalX(arr, brr);
        bufferedReader.close();
    }
}
