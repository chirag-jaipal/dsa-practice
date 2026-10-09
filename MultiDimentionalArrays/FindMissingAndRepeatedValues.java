package MultiDimentionalArrays;

public class FindMissingAndRepeatedValues {
  // Approach 1: O(n ^ 2) time , O(n ^ 2) space
  public static int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    int[] occurence = new int[n * n + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        occurence[grid[i][j]]++;
      }
    }

    int repeated = -1;
    int missing = -1;

    for (int i = 1; i < occurence.length; i++) {
      if (occurence[i] == 2) {
        repeated = i;
      }
      if (occurence[i] == 0) {
        missing = i;
      }
    }

    return new int[] { repeated, missing };
  }

  // Approach 2: O(n ^ 2) time , O(1) space
  public static int[] findMissingAndRepeatedVals(int[][] grid) {
    int n = grid.length;
    int totalValues = n * n;

    long sumExpected = (long) totalValues * (totalValues + 1) / 2;
    long sumSquaresExpected = (long) totalValues * (totalValues + 1)
        * (2L * totalValues + 1) / 6;

    long sum = 0;
    long sumSquares = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sum += grid[i][j];
        sumSquares += (long) grid[i][j] * grid[i][j];
      }
    }

    long sumDifference = sum - sumExpected;
    long sumSquaresDifference = sumSquares - sumSquaresExpected;

    long repeated = (sumDifference + sumSquaresDifference / sumDifference) / 2;
    long missing = repeated - sumDifference;

    return new int[] { (int) repeated, (int) missing };
  }

  public static void main(String[] args) {
    int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
    // int[] result = findMissingAndRepeatedValues(grid);
    int[] result = findMissingAndRepeatedVals(grid);
    System.out.println("REPEATED: " + result[0]);
    System.out.println("MISSING: " + result[1]);
  }
}
