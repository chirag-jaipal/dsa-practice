package Strings;

public class MinimumWindowSubstring {
  // Approach: Using Variable Sliding Window : O(n + m) time and O(1) space
  public static String minWindow(String s, String t) {
    if (s.length() < t.length())
      return "";

    int[] requiredFreq = new int[128];
    int[] windowFreq = new int[128];

    for (char ch : t.toCharArray()) {
      requiredFreq[ch]++;
    }

    int required = 0;
    for (int i = 0; i < 128; ++i) {
      if (requiredFreq[i] > 0) {
        required++;
      }
    }

    int formed = 0;
    int left = 0, right = 0;
    int start = 0;
    int minLen = Integer.MAX_VALUE;

    while (right < s.length()) {
      char ch = s.charAt(right);
      windowFreq[ch]++;

      if (requiredFreq[ch] > 0 && windowFreq[ch] == requiredFreq[ch]) {
        formed++;
      }

      while (formed == required) {
        if (minLen > right - left + 1) {
          minLen = right - left + 1;
          start = left;
        }

        char leftChar = s.charAt(left);
        windowFreq[leftChar]--;

        if (requiredFreq[leftChar] > 0 && windowFreq[leftChar] < requiredFreq[leftChar]) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, minLen + start);
  }

  public static void main(String[] args) {
    String s = "a";
    String t = "b";
    System.out.println("RESULT: " + minWindow(s, t));
  }
}
