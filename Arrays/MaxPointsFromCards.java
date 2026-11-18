package Arrays;

public class MaxPointsFromCards {
  // Brute force: O(k*k) time and O(1) space
  public static int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int maxSum = 0;

    for (int t = 0; t <= k; ++t) {
      int sum = 0;
      for (int front = 0; front < t; ++front) {
        sum += cardPoints[front];
      }

      for (int back = n - 1; back >= n - k + t; --back) {
        sum += cardPoints[back];
      }
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }

  // Optimizzed: O(n) time and O(1) space
  public static int maxScoreV2(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int maxSum = 0;
    int sum = 0;

    for (int i = 0; i < k; ++i) {
      sum += cardPoints[i];
    }
    maxSum = sum;

    for (int j = k - 1; j >= 0; --j) {
      sum += cardPoints[n - k + j] - cardPoints[j];
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] cardPoints = { 9, 7, 7, 9, 7, 7, 9 };
    int k = 7;
    System.out.println("RESULT: " + maxScore(cardPoints, k));
    System.out.println("RESULT: " + maxScoreV2(cardPoints, k));
  }
}
