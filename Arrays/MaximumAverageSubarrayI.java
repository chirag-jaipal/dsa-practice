package Arrays;

public class MaximumAverageSubarrayI {
  // Using Sliding Window: O(n) time and O(1) space
  public static double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    double avg = 0;

    int r = 0;
    while (r < k) {
      sum += nums[r++];
    }
    avg = sum / k;

    while (r < nums.length) {
      sum += nums[r++] - nums[r - k];
      avg = Math.max(avg, sum / k);
      r++;
    }

    return avg;
  }

  public static void main(String[] args) {
    int[] nums = { 5 };
    int k = 1;
    System.out.println("RESULT: " + findMaxAverage(nums, k));
  }
}
