package misc;

import java.util.Map;
import java.util.stream.Collectors;

public class CharFrequencyCounter {
    public static void main(String[] args) {
        String str = "example string";
        Map<Character, Long> charFrequency = countCharFrequency(str);

        // Print the character frequencies
        charFrequency.forEach((character, frequency) ->
                System.out.println(character + ": " + frequency));
    }

    public static Map<Character, Long> countCharFrequency(String str) {
        return str.chars()                                  // Stream of int representing characters
                .mapToObj(c -> (char) c)                    // Convert int to Character
                .filter(c -> !Character.isWhitespace(c))    // Filter out whitespace characters
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));  // Collect to map with counts
    }
}
