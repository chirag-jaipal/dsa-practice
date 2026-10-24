package Arrays;

public class TwoSumII {
  public static int[] twoSum(int[] numbers, int target) {
    int start = 0, end = numbers.length - 1;

    while (start < end) {
      int sum = numbers[start] + numbers[end];

      if (sum == target) {
        return new int[] { start + 1, end + 1 };
      } else if (sum > target) {
        end--;
      } else {
        start++;
      }
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    int[] numbers = { -1, 0 };
    int target = -1;
    int[] res = twoSum(numbers, target);
    System.out.println("INDEX1: " + res[0]);
    System.out.println("INDEX2: " + res[1]);
  }
}
