package Strings;

public class StringCompression {
  public static int compress(char[] chars) {
    int j = 0;
    int count = 1;

    for (int i = 0; i < chars.length; i++) {
      if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
        chars[j] = chars[i];

        if (count > 1) {
          for (char ch : Integer.toString(count).toCharArray()) {
            chars[++j] = ch;
          }
        }

        j++;
        count = 1;
      } else {
        count++;
      }
    }

    return j;
  }

  public static void main(String[] args) {
    // char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
    // 'b' };
    // char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    char[] chars = { 'b', '0', 'l', 'A', ']', '+', 'O', '5', 'j', '4' };

    System.out.println("RESULT: " + compress(chars));
  }
}
