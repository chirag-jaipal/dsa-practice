package Arrays;

public class TrappingRainwater {
  // Approach 1: Brute Force (Scan both sides per column)
  public static int trap(int[] height) {
    int n = height.length;
    int total = 0;

    for (int i = 0; i < n; ++i) {
      int maxLeft = 0, maxRight = 0;

      for (int j = 0; j <= i; ++j) {
        maxLeft = Math.max(maxLeft, height[j]);
      }

      for (int k = i; k < n; ++k) {
        maxRight = Math.max(maxRight, height[k]);
      }

      int cap = Math.min(maxLeft, maxRight);
      total += Math.max(0, cap - height[i]);
    }

    return total;
  }

  // Approach 2: Better (Precompute maxLeft and maxRight Arrays)
  public static int trapV2(int[] height) {
    int n = height.length;

    int[] maxLeft = new int[n];
    maxLeft[0] = height[0];

    int[] maxRight = new int[n];
    maxRight[n - 1] = height[n - 1];

    for (int i = 1; i < n; ++i) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }

    for (int j = n - 2; j >= 0; --j) {
      maxRight[j] = Math.max(maxRight[j + 1], height[j]);
    }

    int total = 0;
    for (int k = 0; k < n; ++k) {
      total += Math.max(0, Math.min(maxLeft[k], maxRight[k]) - height[k]);
    }

    return total;
  }

  // Approach 3: Optimal (Two Pointers)
  public static int trapV3(int[] height) {
    int total = 0;

    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length - 1;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          total += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          total += rightMax - height[right];
        }
        right--;
      }
    }

    return total;
  }

  public static void main(String[] args) {
    int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println("RESULT: " + trap(height));
    System.out.println("RESULT: " + trapV2(height));
    System.out.println("RESULT: " + trapV3(height));
  }
}
