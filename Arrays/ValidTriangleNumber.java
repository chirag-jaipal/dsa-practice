package Arrays;

import java.util.Arrays;

public class ValidTriangleNumber {
  private static boolean isValidTriangle(int a, int b, int c) {
    return ((a + b > c) && (a + c > b) && (b + c > a));
  }

  // Approach 1: Using 3 Nested Loops
  public static int triangleNumber(int[] nums) {
    int n = nums.length;
    int count = 0;

    for (int i = 0; i < n - 2; ++i) {
      for (int j = i + 1; j < n - 1; ++j) {
        for (int k = j + 1; k < n; ++k) {
          if (isValidTriangle(nums[i], nums[j], nums[k])) {
            count++;
          }
        }
      }
    }

    return count;
  }

  // Approach 2: Using Two Pointers + Sorting
  public static int triangleNumberV2(int[] nums) {
    int n = nums.length;
    int count = 0;

    Arrays.sort(nums);

    for (int i = n - 1; i >= 2; --i) {
      int j = 0, k = i - 1;

      while (j < k) {
        if (nums[j] + nums[k] > nums[i]) {
          count += k - j;
          k--;
        } else {
          j++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 3, 4, 4, 5 };
    System.out.println("RESULT: " + triangleNumber(nums));
    System.out.println("RESULT: " + triangleNumberV2(nums));
  }
}
