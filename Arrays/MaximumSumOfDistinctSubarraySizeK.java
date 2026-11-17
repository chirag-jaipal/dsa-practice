package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

  // Optimized (Sliding Window + Frequency Map) : O(n) time and O(k) space
  public static long maximumSubarraySumV2(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    long maxSum = 0;
    long sum = 0;

    for (int r = 0; r < nums.length; ++r) {
      sum += nums[r];
      freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

      if (r >= k) {
        int leftEle = nums[r - k];
        sum -= leftEle;
        freq.put(leftEle, freq.get(leftEle) - 1);
        if (freq.get(leftEle) == 0) {
          freq.remove(leftEle);
        }
      }

      if (r >= k - 1 && freq.size() == k) {
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
    int k = 3;
    System.out.println("RESULT: " + maximumSubarraySum(nums, k));
    System.out.println("RESULT: " + maximumSubarraySumV2(nums, k));
  }
}
