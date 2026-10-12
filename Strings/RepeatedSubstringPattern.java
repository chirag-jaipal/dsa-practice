package Strings;

public class RepeatedSubstringPattern {
  public static boolean repeatedSubstringPattern(String s) {
    int n = s.length();

    for (int len = 1; len <= n / 2; len++) {
      if (n % len == 0) {
        int size = n / len;
        String subStr = s.substring(0, len);
        if (s.equals(subStr.repeat(size))) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String s = "abcabcabcabc";
    System.out.println("RESULT: " + repeatedSubstringPattern(s));
  }
}
