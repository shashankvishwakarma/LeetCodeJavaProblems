package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseInsideCurlyBraces {

  public static void main(String[] args) {
    String input = "abc{def}hikl{mno}p";

    String output = reverseInsideCurlyBraces(input);
    System.out.println("My Output: " + output);

    output = reverseInsideCurlyBracesUsingRegex(input);
    System.out.println("Output using regex: " + output);
  }

  private static String reverseInsideCurlyBraces(String input) {
    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    boolean insideCurlyBraces = false;

    for (char c : input.toCharArray()) {
      if (c == '{') {
        insideCurlyBraces = true;
        continue;
      } else if (c == '}') {
        insideCurlyBraces = false;
        result.append("{");
        result.append(temp.reverse());
        result.append("}");
        temp.setLength(0);
        continue;
      }

      if (insideCurlyBraces) {
        temp.append(c);
      } else {
        result.append(c);
      }
    }
    return result.toString();

  }

  public static String reverseInsideCurlyBracesUsingRegex(String input) {
    Pattern pattern = Pattern.compile("\\{([^{}]*)\\}");
    Matcher matcher = pattern.matcher(input);

    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      String insideCurlyBraces = matcher.group(1);
      matcher.appendReplacement(result,
          "{" + new StringBuilder(insideCurlyBraces).reverse().toString() + "}");
    }
    matcher.appendTail(result);

    return result.toString();
  }
}
