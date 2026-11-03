package Strings;

import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueBinaryString {
  // Approach 1: Using Recursion + HashSet
  static String findDifferentBinaryString(String[] nums) {
    int n = nums.length;
    HashSet<String> set = new HashSet<>(Arrays.asList(nums));
    StringBuilder sb = new StringBuilder();
    return findDifferentBinaryStringHelper(n, set, sb);
  }

  static String findDifferentBinaryStringHelper(int n, HashSet<String> set, StringBuilder sb) {
    if (n == 0) {
      if (!set.contains(sb.toString())) {
        return sb.toString();
      }
      return "";
    }

    sb.append(0);
    String result = findDifferentBinaryStringHelper(n - 1, set, sb);
    sb.deleteCharAt(sb.length() - 1);
    if (!result.isEmpty()) {
      return result;
    }

    sb.append(1);
    result = findDifferentBinaryStringHelper(n - 1, set, sb);
    sb.deleteCharAt(sb.length() - 1);
    return result;
  }

  // Approach 2: Using base 10 integers
  static String findDifferentBinaryStringV2(String[] nums) {
    int n = nums.length;
    HashSet<String> set = new HashSet<>(Arrays.asList(nums));

    for (int i = 0; i < Math.pow(2, n); ++i) {
      String s = Integer.toBinaryString(i);
      s = "0".repeat(n - s.length()) + s;
      if (!set.contains(s)) {
        return s;
      }
    }

    return "";
  }

  // Approach 3: Cantor's Diagonalization
  static String findDifferentBinaryStringV3(String[] nums) {
    int n = nums.length;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; ++i) {
      char diagonal = nums[i].charAt(i);
      sb.append(diagonal == '0' ? "1" : "0");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String[] nums = { "111", "011", "001" };
    System.out.println("RESULT: " + findDifferentBinaryString(nums));
    System.out.println("RESULT: " + findDifferentBinaryStringV2(nums));
    System.out.println("RESULT: " + findDifferentBinaryStringV3(nums));
  }
}
