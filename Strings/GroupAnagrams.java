package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  // Approach 1: Brute Force ; O(n^2 * klogk) time and O(n*k) space
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    boolean[] used = new boolean[strs.length];

    for (int i = 0; i < strs.length; i++) {
      if (used[i])
        continue;

      List<String> group = new ArrayList<>();
      group.add(strs[i]);
      used[i] = true;

      for (int j = i + 1; j < strs.length; j++) {
        if (!used[j] && areAnagrams(strs[i], strs[j])) {
          group.add(strs[j]);
          used[j] = true;
        }
      }
      result.add(group);
    }
    return result;
  }

  private static boolean areAnagrams(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1);
    Arrays.sort(c2);
    return Arrays.equals(c1, c2);
  }

  // Approach 1: Frequency Count; O(n^2 * k) time and O(n) space
  public static List<List<String>> groupAnagramsV2(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    boolean[] used = new boolean[strs.length];

    for (int i = 0; i < strs.length; i++) {
      if (used[i])
        continue;

      List<String> group = new ArrayList<>();
      group.add(strs[i]);
      used[i] = true;

      for (int j = i + 1; j < strs.length; j++) {
        if (!used[j] && areAnagramsV2(strs[i], strs[j])) {
          group.add(strs[j]);
          used[j] = true;
        }
      }
      result.add(group);
    }
    return result;
  }

  private static boolean areAnagramsV2(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;

    int[] freq = new int[26];

    for (int i = 0; i < s1.length(); i++)
      freq[s1.charAt(i) - 'a']++;

    for (int j = 0; j < s2.length(); j++)
      freq[s2.charAt(j) - 'a']--;

    for (int ele : freq)
      if (ele != 0)
        return false;

    return true;
  }

  // Approach 3: Sorted Signature ; O(n*klogk) time and O(n*k) space
  public static List<List<String>> groupAnagramsV3(String[] strs) {
    HashMap<String, List<String>> groups = new HashMap<>();

    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String sig = new String(c);
      groups.computeIfAbsent(sig, key -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(groups.values());
  }

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    List<List<String>> res1 = groupAnagrams(strs);
    System.out.println(res1);

    List<List<String>> res2 = groupAnagramsV2(strs);
    System.out.println(res2);

    List<List<String>> res3 = groupAnagramsV2(strs);
    System.out.println(res3);
  }
}
