package Arrays;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraySizeK {
  // Brute-force: O(n * k) time and O(k) space
  public static long maximumSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    long maxSum = 0;

    for (int i = 0; i <= nums.length - k; ++i) {
      long sum = 0;
      for (int j = i; j < i + k; ++j) {
        if (!set.contains(nums[j])) {
          sum += nums[j];
          set.add(nums[j]);
        } else {
          sum = 0;
          break;
        }
      }
      maxSum = Math.max(sum, maxSum);
      set.clear();
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 4, 4 };
    int k = 3;
    System.out.println("RESULT: " + maximumSubarraySum(nums, k));
  }
}
