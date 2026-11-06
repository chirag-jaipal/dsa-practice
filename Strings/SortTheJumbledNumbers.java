package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class SortTheJumbledNumbers {
  // Approach 1: Naive Approach
  public static int[] sortJumbled(int[] mapping, int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; ++i) {
      String num = String.valueOf(nums[i]);
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < num.length(); ++j) {
        sb.append(mapping[Integer.parseInt(String.valueOf(num.charAt(j)))]);
      }

      map.put(nums[i], Integer.parseInt(sb.toString()));
    }

    Integer[] sortedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(sortedNums, (a, b) -> Integer.compare(map.get(a), map.get(b)));

    for (int i = 0; i < nums.length; ++i) {
      nums[i] = sortedNums[i];
    }

    return nums;
  }

  // Approach 2: Optimized Approach
  public static int[] sortJumbledV2(int[] mapping, int[] nums) {
    int n = nums.length;
    long[] keys = new long[n];

    for (int i = 0; i < n; i++) {
      int number = nums[i];

      int divisor = 1;
      while (number / divisor >= 10) {
        divisor *= 10;
      }

      int mapped = 0;

      do {
        int digit = number / divisor;
        mapped = mapped * 10 + mapping[digit];

        number %= divisor;
        divisor /= 10;
      } while (divisor > 0);

      keys[i] = (long) mapped * n + i;
    }

    Arrays.sort(keys);

    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      int originalIndex = (int) (keys[i] % n);
      result[i] = nums[originalIndex];
    }

    return result;
  }

  public static void main(String[] args) {
    int[] mapping = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] nums = { 789, 456, 123 };
    int[] result = sortJumbled(mapping, nums);
    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}
