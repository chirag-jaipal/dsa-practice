package Strings;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfSubstringsWithDominantOnes {
  // Optimized Approach
  static int numberOfSubstrings(String s) {
    int n = s.length();
    List<Integer> zeroes = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == '0') {
        zeroes.add(i);
      }
    }
    // Add a sentinel value to handle the last segment of ones
    zeroes.add(n);

    int count = 0;
    int zeroIdx = 0; // index in the zeroes list of the first zero at or after i

    for (int i = 0; i < n; ++i) {
      while (zeroIdx < zeroes.size() - 1 && zeroes.get(zeroIdx) < i) {
        zeroIdx++;
      }

      count += zeroes.get(zeroIdx) - i;

      int k = 1;
      while (zeroIdx + k - 1 < zeroes.size() - 1 && k * (k + 1) <= n - i) {
        int lastZero = zeroes.get(zeroIdx + k - 1); // Last zero in the current segment of k zeros
        int nextZero = zeroes.get(zeroIdx + k); // Next zero after the current segment of k zeros

        int minIdx = i + k + k * k - 1; // Minimum index that satisfies the condition for k zeros

        // Calculate the valid starting index for the substring
        int validStart = Math.max(lastZero, minIdx);
        count += Math.max(0, nextZero - validStart);

        k++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    String s = "101101";
    System.out.println("RESULT: " + numberOfSubstrings(s));
  }
}
