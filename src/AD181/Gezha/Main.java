package AD181.Gezha;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String input = Main.getString("Input a character string");
    if (Main.stringEndsWith(input, "ed")) {
      System.out.println("The string ends with 'ed'");
    } else {
      System.out.println("The string does not end with 'ed'");
    }

    input = Main.getString("Input a string of digits");
    System.out.println("Sum of digits = " + Main.sumDigitsInString(input));

    input = Main.getString("Input a string of characters");
    System.out.println("Length of the longest block: " + Main.getMaxBlockLength(input));

    input = Main.getString("Input a string with words");
    printWordsInString(input);

    String input1 = Main.getString("Input the first string");
    String input2 = Main.getString("Input the second string");
    String mergedString = Main.getMergedString(input1, input2);
    System.out.println("Merged string:\n" + mergedString);
  }

  private static boolean stringEndsWith(String string, String ending) {
    return string.endsWith(ending);
  }

  private static int sumDigitsInString(String string) {
    int sum = 0;
    for (int charIndex = 0; charIndex < string.length(); ++charIndex) {
      int charValue = Character.getNumericValue(string.charAt(charIndex));
      sum += charValue;
    }
    return sum;
  }

  private static int getMaxBlockLength(String string) {
    int currentBlockLength = 0;
    int maxBlockLength = 0;
    char lastBlockCharacter = '\0';
    for (int charIndex = 0; charIndex < string.length(); ++charIndex) {
      char currentCharacter = string.charAt(charIndex);
      if (currentCharacter != lastBlockCharacter) {
        currentBlockLength = 0;
      }

      ++currentBlockLength;
      lastBlockCharacter = currentCharacter;

      if (currentBlockLength > maxBlockLength) {
        maxBlockLength = currentBlockLength;
      }
    }
    return maxBlockLength;
  }

  private static void printWordsInString(String string) {
    System.out.println("Separate words in the entered string:");
    int wordStartIndex = 0;
    int wordEndIndex = 0;
    for (int charIndex = 0; charIndex < string.length(); ++charIndex) {
      if (string.charAt(charIndex) == ' ') {
        // this "if" prevents errors with multiple whitespaces
        if (wordStartIndex != wordEndIndex) {
          System.out.println(string.substring(wordStartIndex, wordEndIndex));
        }
        wordStartIndex = charIndex + 1;
      }

      wordEndIndex = charIndex + 1;
    }
    System.out.println(string.substring(wordStartIndex, wordEndIndex));
  }

  private static String getMergedString(String string1, String string2) {
    int maxLength = Math.max(string1.length(), string2.length());

    // builds the merged string from both strings
    StringBuilder resultingString = new StringBuilder();
    for (int charIndex = 0; charIndex < maxLength; ++charIndex) {
      if (charIndex < string1.length()) {
        resultingString.append(string1.charAt(charIndex));
      }

      if (charIndex < string2.length()) {
        resultingString.append(string2.charAt(charIndex));
      }
    }

    return resultingString.toString();
  }

  private static String getString(String prompt) {
    Scanner console = new Scanner(System.in);
    System.out.println(prompt);
    String line = "";
    do {
      line = console.nextLine();
    } while (line.length() == 0);

    return line;
  }
}
