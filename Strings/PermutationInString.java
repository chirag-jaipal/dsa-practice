package Strings;

public class PermutationInString {
  private static boolean sameFreq(int[] reqFreq, int[] winFreq) {
    for (int i = 0; i < 26; ++i) {
      if (reqFreq[i] != winFreq[i]) {
        return false;
      }
    }
    return true;
  }

  // Approach: Brute Force O(n * m) time and O(1) space
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;

    int[] requiredFreq = new int[26];
    for (char ch : s1.toCharArray()) {
      requiredFreq[ch - 'a']++;
    }

    for (int i = 0; i <= s2.length() - s1.length(); ++i) {
      if (requiredFreq[s2.charAt(i) - 'a'] == 0) {
        continue;
      }

      int[] windowFreq = new int[26];
      for (int j = i; j < (i + s1.length()); ++j) {
        windowFreq[s2.charAt(j) - 'a']++;
      }

      boolean isIncluded = sameFreq(requiredFreq, windowFreq);
      if (isIncluded) {
        return true;
      }
    }

    return false;
  }

  // Approach: Sliding Window O(n) time and O(1) space
  public static boolean checkInclusionV2(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;

    int[] requiredFreq = new int[26];
    int[] windowFreq = new int[26];

    for (char ch : s1.toCharArray()) {
      requiredFreq[ch - 'a']++;
    }

    int r = 0;
    while (r < s1.length()) {
      windowFreq[s2.charAt(r) - 'a']++;
      r++;
    }

    int l = 0;
    while (r < s2.length()) {
      if (sameFreq(requiredFreq, windowFreq)) {
        return true;
      }

      windowFreq[s2.charAt(r++) - 'a']++;
      windowFreq[s2.charAt(l++) - 'a']--;
    }

    return sameFreq(requiredFreq, windowFreq);
  }

  public static void main(String[] args) {
    String s1 = "ab";
    String s2 = "eidboaoo";
    System.out.println("RESULT: " + checkInclusion(s1, s2));
    System.out.println("RESULT: " + checkInclusionV2(s1, s2));
  }
}
