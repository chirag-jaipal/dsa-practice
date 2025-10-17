package Strings;

public class SumOfAllSubstrings {

    public static void main(String[] args) {
        String s = "6759";

        // Call and print the result from the O(n^2) approach.
        int sum = sumSubstrings(s);
        System.out.println(sum);

        // Call and print the result from the optimized O(n) approach.
        int ans = sum_substrings(s);
        System.out.println(ans);
    }

    // Approach1: Brute-force
    // Time-Complexity: O(n^2)
    public static int sumSubstrings(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                // Extract the substring, convert to integer, and add to sum.
                sum += Integer.parseInt(s.substring(i, j));
            }
        }
        return sum;
    }

    // Approach2: Optimized
    // Time-Complexity: O(n)
    public static int sum_substrings(String s) {
        int n = s.length();

        int totalSum = 0; // Final answer
        int sumPrevIdx = 0; // Stores the sum of substrings ending at the previous index

        for (int i = 0; i < n; i++) {
            // Convert character to its integer value (e.g., '6' -> 6)
            int currDigit = s.charAt(i) - '0';

            // Calculate sum of all substrings ending at the current index
            // Formula: sum(i) = 10 * sum(i-1) + (i+1) * current_digit
            int currSum = (10 * sumPrevIdx) + (i + 1) * currDigit;

            // Update sumPrevIdx for the next iteration
            sumPrevIdx = currSum;

            // Add the current sum to the total
            totalSum += currSum;
        }
        
        return totalSum;
    }
}
