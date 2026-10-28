package Strings;

import java.util.Arrays;

public class DetermineTwoStringsAreClose {
  // Approach 1: Using O(1) space but O(26log26) time
  public static boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    int[] freqArr1 = new int[26];
    int[] freqArr2 = new int[26];

    for (int i = 0; i < word1.length(); ++i) {
      freqArr1[word1.charAt(i) - 'a']++;
      freqArr2[word2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < freqArr1.length; ++i) {
      if ((freqArr1[i] == 0) != (freqArr2[i] == 0)) {
        return false;
      }
    }

    Arrays.sort(freqArr1);
    Arrays.sort(freqArr2);

    return Arrays.equals(freqArr1, freqArr2);
  }

  // Approach 2: Use O(n) Space but O(n) time
  public static boolean closeStringsOptimized(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    for (int i = 0; i < word1.length(); i++) {
      freq1[word1.charAt(i) - 'a']++;
      freq2[word2.charAt(i) - 'a']++;
    }

    int[] frequencyCounts1 = new int[word1.length() + 1];
    int[] frequencyCounts2 = new int[word2.length() + 1];

    for (int i = 0; i < 26; i++) {
      if ((freq1[i] == 0) != (freq2[i] == 0)) {
        return false;
      }

      if (freq1[i] > 0) {
        frequencyCounts1[freq1[i]]++;
        frequencyCounts2[freq2[i]]++;
      }
    }

    for (int i = 1; i <= word1.length(); i++) {
      if (frequencyCounts1[i] != frequencyCounts2[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String word1 = "cabbba";
    String word2 = "abbccc";
    System.out.println("RESULT: " + closeStrings(word1, word2));
  }
}
