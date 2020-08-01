package hackerrank.problemsolving.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DayOfTheProgrammer {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String date = "";
        if(year < 1918) {                                                   //Julian check for leap year
            date += (year % 4 == 0) ? "12.09." + year : "13.09." + year;
        } else if(year == 1918) {                                           //Special case: transition year
            date += "26.09." + year;
        } else {                                                            //Gregorian check for leap year
            date += ((year % 400 == 0) ||
                    (year % 4 == 0 && year % 100 != 0)) ? "12.09." + year : "13.09." + year;
        }
        return date;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());
        String result = dayOfProgrammer(year);

        bufferedReader.close();
    }
}