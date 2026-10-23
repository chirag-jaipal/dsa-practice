package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  private static boolean isPalindrome(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }

    return true;
  }

  private static void partitionHelper(int idx, String s, List<String> subStr, List<List<String>> res) {
    if (idx == s.length()) {
      res.add(new ArrayList<>(subStr));
      return;
    }

    for (int i = idx; i < s.length(); ++i) {
      if (isPalindrome(s, idx, i)) {
        subStr.add(s.substring(idx, i + 1));
        partitionHelper(i + 1, s, subStr, res);
        subStr.remove(subStr.size() - 1);
      }
    }
  }

  public static List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    List<String> subStr = new ArrayList<>();
    partitionHelper(0, s, subStr, res);
    return res;
  }

  public static void main(String[] args) {
    String s = "aab";
    List<List<String>> res = partition(s);
    System.out.println(res);
  }
}
