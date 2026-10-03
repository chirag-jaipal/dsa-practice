package Arrays;

public class MaximumSubarray {
  // Approach 1: Nested Loops
  public static int maxSubArray(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int currSum = 0;
      for (int j = i; j < n; j++) {
        currSum += nums[j];
        if (currSum > max) {
          max = currSum;
        }
      }
    }

    return max;
  }

  // Approach 2: Kadane's Algorithm
  public static int maxSubarray(int[] nums) {
    int n = nums.length;

    int currSum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      currSum += nums[i];
      max = Math.max(max, currSum);
      if (currSum < 0) {
        currSum = 0;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println("RESULT1: " + maxSubArray(nums));
    System.out.println("RESULT2: " + maxSubarray(nums));
  }
}
