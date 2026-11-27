package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
  // Approach 1: Brute Force O(n^2) time and O(1) space
  public static int longestValidParentheses(String s) {
    int best = 0;

    for (int i = 0; i < s.length(); ++i) {
      int bal = 0;
      for (int j = i; j < s.length(); ++j) {
        bal += ((s.charAt(j) == '(') ? 1 : -1);
        if (bal < 0)
          break;
        if (bal == 0)
          best = Math.max(best, j - i + 1);
      }
    }
    return best;
  }

  // Approach 2: Using index stack with base O(n) time and o(n) space
  public static int longestValidParenthesesV2(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);

    int best = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(')
        stack.push(i);
      else {
        stack.pop();
        if (stack.isEmpty())
          stack.push(i);
        else
          best = Math.max(best, i - stack.peek());
      }
    }
    return best;
  }

  public static void main(String[] args) {
    String s = ")()())";
    System.out.println("RESULT: " + longestValidParentheses(s));
    System.out.println("RESULT: " + longestValidParenthesesV2(s));
  }
}
