package Strings;

public class StringArraysAreEquivalent {
  // Approach 1: Naive (using built in methods) : Time efficient
  public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    StringBuilder w1 = new StringBuilder();
    StringBuilder w2 = new StringBuilder();

    for (int i = 0; i < word1.length; i++) {
      w1 = w1.append(word1[i]);
    }

    for (int i = 0; i < word2.length; i++) {
      w2 = w2.append(word2[i]);
    }

    return w1.compareTo(w2) == 0;
  }

  // Approach 2: Space Efficient
  public static boolean arrayStringsAreEquivalent(String[] word1, String[] word2) {
    int w1 = 0, w2 = 0;
    int i1 = 0, i2 = 0;

    while (w1 < word1.length && w2 < word2.length) {
      if (word1[w1].charAt(i1) != word2[w2].charAt(i2)) {
        return false;
      }
      i1++;
      i2++;

      if (i2 == word2[w2].length()) {
        w2++;
        i2 = 0;
      }

      if (i1 == word1[w1].length()) {
        w1++;
        i1 = 0;
      }
    }

    return w1 == word1.length && w2 == word2.length;
  }

  public static void main(String[] args) {
    String[] word1 = { "abc", "d", "defg" };
    String[] word2 = { "abcddefg" };
    System.out.println("RESULT: " + arrayStringsAreEqual(word1, word2));
    System.out.println("RESULT: " + arrayStringsAreEquivalent(word1, word2));
  }
}
