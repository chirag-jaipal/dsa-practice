package Strings;

public class ShortestPalindrome {
  // Approach 1 : Using Nested Loop (O(n^2) time)
  public static String shortestPalindrome(String s) {
    if (s == null || s.length() == 0)
      return s;

    if (isPalindrome(s)) {
      return s;
    }

    StringBuilder str = new StringBuilder(s);

    for (int i = str.length() - 1; i >= 1; --i) {
      StringBuilder subStr = new StringBuilder(str.substring(i));
      subStr.reverse();
      subStr.append(str);

      if (isPalindrome(subStr.toString())) {
        return subStr.toString();
      }
    }

    return s;
  }

  private static boolean isPalindrome(String str) {
    int start = 0, end = str.length() - 1;

    while (start <= end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  // Approach 2: Using KMP Algorithm
  public static String shortestPalindromeV2(String s) {
    if (s == null || s.length() == 0)
      return s;

    String reversed = new StringBuilder(s).reverse().toString();
    String newStr = s + "#" + reversed;

    int[] lps = new int[newStr.length()];

    int j = 0, i = 1;
    while (i < newStr.length()) {
      if (newStr.charAt(i) == newStr.charAt(j)) {
        j++;
        lps[i] = j;
        i++;
      } else {
        if (j == 0) {
          lps[i] = 0;
          i++;
        } else {
          j = lps[j - 1];
        }
      }
    }

    int longestPalindrome = lps[lps.length - 1];

    return reversed.substring(0, reversed.length() - longestPalindrome) + s;
  }

  public static void main(String[] args) {
    String s = "abcd";
    System.out.println("RESULT: " + shortestPalindrome(s));
    System.out.println("RESULT: " + shortestPalindromeV2(s));
  }
}
