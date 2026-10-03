package Arrays;

public class ContainerWithMostWater {
  // Approach 1: Nested Loops
  public static int maxArea(int[] height) {
    int n = height.length;

    int maxArea = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int area = Math.min(height[i], height[j]) * (j - i);
        maxArea = (area > maxArea) ? area : maxArea;
      }
    }

    return maxArea;
  }

  // Approach 2: Two Pointers
  public static int maximumArea(int[] height) {
    int n = height.length;
    int maxArea = 0;

    int left = 0, right = n - 1;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      maxArea = (area > maxArea) ? area : maxArea;

      if (height[left] <= height[right])
        left++;
      else
        right--;
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    System.out.println("AREA1: " + maxArea(height));
    System.out.println("AREA12 " + maximumArea(height));
  }
}
