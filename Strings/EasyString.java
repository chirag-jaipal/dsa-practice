package Strings;

public class EasyString {
    public static void main(String[] args) {
        String s = "aaABBb";
        String ans = compressedString(s);
        System.out.println(ans); // Expected output: "3a3b"
    }

    // Two-pointer (sliding window) approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String compressedString(String s) {
        int n = s.length();

        // Use StringBuilder for efficient string concatenation in a loop.
        StringBuilder newStr = new StringBuilder();

        // Initialize two pointers: i (slow) marks the start of a sequence, j (fast) scans ahead.
        int i = 0, j = 0;

        // Loop until the fast pointer has scanned the entire string.
        while (j < n) {
            // Get the lowercase characters at both pointers for case-insensitive comparison.
            char charAtIdxJ = Character.toLowerCase(s.charAt(j));
            char charAtIdxI = Character.toLowerCase(s.charAt(i));

            // If the character changes, the current sequence has ended.
            if (charAtIdxI != charAtIdxJ) {
                // Calculate the frequency by the distance between pointers.
                int freq = j - i;
                // Append the frequency and the character of the sequence.
                newStr.append(freq).append(charAtIdxI);
                // Move the slow pointer to the start of the new sequence.
                i = j;
            }
            j++;
        }

        // After the loop, append the last remaining sequence.
        // This is needed because the 'if' condition won't trigger for the final run of characters.
        newStr.append(j - i).append(Character.toLowerCase(s.charAt(i)));

        return newStr.toString();
    }
}
