package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class LongestSubstringWithoutRepeats {
  private static boolean isUnique(String s, int l, int r) {
    Set<Character> set = new HashSet<>();
    for (int i = l; i <= r; ++i) {
      if (!set.add(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  // Approach 1: Brute Force O(n * n) time and O(n) space
  public static int lengthOfLongestSubstring(String s) {
    int len = 0;

    int l = 0, r = 0;
    while (r < s.length()) {
      if (isUnique(s, l, r)) {
        len = Math.max(len, r - l + 1);
        r++;
      } else {
        l++;
      }
    }

    return len;
  }

  // Approach 2: Sliding window + set : O(n) time and O(n) space
  public static int lengthOfLongestSubstringV2(String s) {
    int maxLen = 0;
    Set<Character> set = new HashSet<>();

    int l = 0, r = 0;
    while (r < s.length()) {
      while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l));
        l++;
      }
      set.add(s.charAt(r));
      maxLen = Math.max(maxLen, r - l + 1);
      r++;
    }
    return maxLen;
  }

  // Approach 3: Sliding window + map : O(n) time and O(n) space
  public static int lengthOfLongestSubstringV3(String s) {
    int maxLen = 0;
    Map<Character, Integer> map = new HashMap<>();

    int l = 0, r = 0;
    while (r < s.length()) {
      if (map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l) {
        l = map.get(s.charAt(r)) + 1;
      }
      map.put(s.charAt(r), r);
      maxLen = Math.max(maxLen, r - l + 1);
      r++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String s = "bbbbb";
    System.out.println("RESULT: " + lengthOfLongestSubstring(s));
    System.out.println("RESULT: " + lengthOfLongestSubstringV2(s));
    System.out.println("RESULT: " + lengthOfLongestSubstringV3(s));
  }
}
