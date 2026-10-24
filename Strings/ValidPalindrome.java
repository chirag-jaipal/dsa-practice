package Strings;

public class ValidPalindrome {
  private static boolean isAlphanumeric(char c) {
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
        || (c >= '0' && c <= '9');
  }

  // Approach 1: Using Two Pass + O(n) Space
  public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isAlphanumeric(c)) {
        sb.append(Character.toLowerCase(c));
      }
    }

    int start = 0, end = sb.length() - 1;
    while (start <= end) {
      if (sb.charAt(start++) != sb.charAt(end--)) {
        return false;
      }
    }

    return true;
  }

  // Approach 2: Using One Pass + O(1) Space
  public static boolean isPalindromeV2(String s) {
    int start = 0, end = s.length() - 1;

    while (start < end) {
      char startChar = s.charAt(start);
      char endChar = s.charAt(end);

      if (!isAlphanumeric(startChar)) {
        start++;
        continue;
      }
      if (!isAlphanumeric(endChar)) {
        end--;
        continue;
      }

      if (Character.toLowerCase(endChar) != Character.toLowerCase(startChar)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println("RESULT: " + isPalindrome(s));
    System.out.println("RESULT: " + isPalindromeV2(s));
  }
}
