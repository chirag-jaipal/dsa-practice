package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
  // Approach 1: Using Recursion O(n + m) time and O(n + m) space
  // n = length of the encoded string, m = length of the decoded string
  private static String decode(String s, int[] idx) {
    StringBuilder res = new StringBuilder();

    while (idx[0] < s.length()) {
      char ch = s.charAt(idx[0]);

      if (Character.isDigit(ch)) {
        int num = 0;
        while (idx[0] < s.length() &&
            Character.isDigit(s.charAt(idx[0]))) {
          num = num * 10 + (s.charAt(idx[0]) - '0');
          idx[0]++;
        }
        idx[0]++;

        String decoded = decode(s, idx);
        res.append(decoded.repeat(num));
      } else if (ch == ']') {
        idx[0]++;
        return res.toString();
      } else {
        res.append(ch);
        idx[0]++;
      }
    }
    return res.toString();
  }

  public static String decodeString(String s) {
    return decode(s, new int[] { 0 });
  }

  // Approach 2: Using Stack O(n + m) time and O(n + m) space
  // n = length of the encoded string, m = length of the decoded string
  public static String decodeStringUsingStack(String s) {
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder> currentStack = new ArrayDeque<>();

    StringBuilder res = new StringBuilder();
    int num = 0;

    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      } else if (ch == '[') {
        countStack.push(num);
        currentStack.push(res);

        num = 0;
        res = new StringBuilder();
      } else if (ch == ']') {
        int count = countStack.pop();
        StringBuilder prev = currentStack.pop();

        prev.append(res.toString().repeat(count));
        res = prev;
      } else {
        res.append(ch);
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    String s = "3[a2[c]]";
    System.out.println("RESULT: " + decodeString(s));
    System.out.println("RESULT: " + decodeStringUsingStack(s));
  }
}
