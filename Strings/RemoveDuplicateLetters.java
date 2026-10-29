package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
  static String removeDuplicateLetters(String s) {
    int n = s.length();
    int[] freq = new int[26];

    for (int i = 0; i < n; i++) {
      freq[s.charAt(i) - 'a']++;
    }

    Deque<Character> stack = new ArrayDeque<>();
    boolean[] seen = new boolean[26];

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      int idx = c - 'a';

      freq[idx]--;

      if (seen[idx]) {
        continue;
      }

      while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
        char removed = stack.pop();
        seen[removed - 'a'] = false;
      }

      stack.push(c);
      seen[idx] = true;
    }

    StringBuilder sb = new StringBuilder(stack.size());
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String s = "cbacdcbc";
    System.out.println("RESULT: " + removeDuplicateLetters(s));
  }
}
