package hackerrank.problemsolving.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        int n = grades.size();
        List<Integer> roundedGrades = new ArrayList<>();

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int grade = grades.get(gradesItr);
            int gradesItem = (grade < 38 || grade % 5 < 3 ? grade : grade + (5 - (grade % 5)));
            roundedGrades.add(gradesItem);
        }
        return roundedGrades;

    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedReader.close();
    }
}
