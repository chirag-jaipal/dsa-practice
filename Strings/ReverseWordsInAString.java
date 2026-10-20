package Strings;

public class ReverseWordsInAString {
  // Approach 1 : Using built in methods
  public static String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");

    StringBuilder res = new StringBuilder();

    for (int word = words.length - 1; word >= 0; --word) {
      res.append(words[word]).append(" ");
    }

    return res.toString().trim();
  }

  // Approach 2 : Using Reversal and three pointers approach
  public static String reverseWordsV2(String s) {
    char[] str = s.toCharArray();
    int n = str.length;

    reverse(str, 0, n - 1);

    int l = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i] != ' ') {
        if (l != 0) {
          str[l++] = ' ';
        }

        int f = l;
        while (i < n && str[i] != ' ') {
          str[l++] = str[i++];
        }

        reverse(str, f, l - 1);
      }
    }

    return new String(str, 0, l);
  }

  private static void reverse(char[] str, int start, int end) {
    while (start < end) {
      char temp = str[start];
      str[start] = str[end];
      str[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    String s = "a good   example";
    System.out.println("RESUT: " + "'" + reverseWords(s) + "'");
    System.out.println("RESUT: " + "'" + reverseWordsV2(s) + "'");
  }
}
