package Strings;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        String s = " pqr   mno ";
        String ans = reverseWords(s);
        System.out.println("'" + ans + "'");
    }

    public static String reverseWords(String s) {
        // Trim leading/trailing whitespace and split by one or more spaces.
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder for efficient string building.
        StringBuilder newStr = new StringBuilder();

        for (String word : words) {
            // Create a new StringBuilder for the current word to reverse it.
            StringBuilder reversedWord = new StringBuilder(word);

            // Append the reversed word and a single space to the result.
            newStr.append(reversedWord.reverse()).append(" ");
        }

        // Convert to a string and trim the final trailing space added by the loop.
        return newStr.toString().trim();
    }
}
