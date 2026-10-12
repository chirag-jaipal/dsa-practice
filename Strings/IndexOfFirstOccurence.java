package Strings;

public class IndexOfFirstOccurence {
  // Approach 1: Using built-in method
  public static int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  // Approach 2: Without using built-in method
  public static int strStrV2(String haystack, String needle) {
    int n = haystack.length(), m = needle.length();

    if (m > n) {
      return -1;
    }

    for (int i = 0; i <= n - m; i++) {
      int j = 0;
      while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      }
      if (j == m) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    String haystack = "mississippi";
    String needle = "issip";
    System.out.println("INDEX: " + strStr(haystack, needle));
    System.out.println("INDEX: " + strStrV2(haystack, needle));
  }
}
