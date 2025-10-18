package Strings;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        // Input string contains lower case alphabets only (given)
        String s = "character";

        // Call and print the result from the optimized O(n) method.
        char ans = nonRepeatingChar(s);
        System.out.println(ans);

        // Call and print the result from the brute-force O(n^2) method.
        char res = non_repeating_char(s);
        System.out.println(res);
    }

    // Approach1: Frequency Count, Two Pass Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static char nonRepeatingChar(String s) {
        int n = s.length();
        // Frequency array to store counts of each character ('a' to 'z').
        int[] freqCount = new int[26];

        // Pass 1: Count the frequency of each character in the string.
        for (int i = 0; i < n; i++)
            freqCount[s.charAt(i) - 'a']++;

        // Pass 2: Find the first character with a frequency of 1.
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (freqCount[currChar - 'a'] == 1)
                return currChar; // Found it!
        }

        // If no non-repeating character is found, return '$'.
        return '$';
    }

    // Approach1: Brute Force Approach, Nested Loops
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static char non_repeating_char(String s) {
        int n = s.length();

        // Outer loop: picks a character to check.
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            Boolean isDuplicate = false;

            // Inner loop: scans the entire string for duplicates.
            for (int j = 0; j < n; j++) {
                // If a duplicate is found (at a different index), set flag and break.
                if (ch == s.charAt(j) && j != i) {
                    isDuplicate = true;
                    break;
                }
            }
            // If the flag is still false after the inner loop, we found our answer.
            if (!isDuplicate)
                return ch;
        }

        // If the outer loop completes, no unique character exists.
        return '$';
    }
}
