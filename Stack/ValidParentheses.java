package Stack;

import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;

public class ValidParentheses {
  // Approach 1: Brute Force O(n^2) time and O(n) space
  public static boolean isValid(String s) {
    while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
      s = s.replace("()", "");
      s = s.replace("{}", "");
      s = s.replace("[]", "");
    }
    return s.isEmpty();
  }

  // Approach 2: Using Stack O(n) time and O(n) space
  public static boolean isValidOptimized(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      if (map.containsKey(ch)) {
        if (stack.isEmpty() || map.get(ch) != stack.pop()) {
          return false;
        }
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "{[()]}";
    System.out.println("RESULT: " + isValid(s));
    System.out.println("RESULT: " + isValidOptimized(s));
  }
}
