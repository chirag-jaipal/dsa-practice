package Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
  // Approach 1: Brute Force O(n * n) time and O(n) space
  public static int characterReplacement(String s, int k) {
    int maxLen = 0;

    for (int i = 0; i < s.length(); ++i) {
      Map<Character, Integer> freq = new HashMap<>();

      for (int j = i; j < s.length(); ++j) {
        freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
        int maxFreq = Collections.max(freq.values());

        int len = j - i + 1;
        if ((len - maxFreq) <= k) {
          maxLen = Math.max(maxLen, len);
        } else {
          break;
        }
      }
    }
    return maxLen;
  }

  // Approach 2: Variable Sliding Window O(n) time and O(1) space
  public static int characterReplacementV2(String s, int k) {
    int maxLen = 0;
    int maxFreq = 0;
    int[] freq = new int[26];

    int l = 0, r = 0;
    while (r < s.length()) {
      freq[s.charAt(r) - 'A']++;
      maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

      if ((r - l + 1) - maxFreq > k) {
        freq[s.charAt(l) - 'A']--;
        l++;
      }
      maxLen = Math.max(maxLen, r - l + 1);
      r++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s = "AABABBA";
    int k = 1;
    System.out.println("RESULT: " + characterReplacement(s, k));
    System.out.println("RESULT: " + characterReplacementV2(s, k));
  }
}
