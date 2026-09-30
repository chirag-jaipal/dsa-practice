package Arrays;

public class SearchInsertPosition {
  public static int searchInsert(int nums[], int target) {
    int n = nums.length;
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 3, 5, 6 };
    int target = 7;

    int res = searchInsert(nums, target);
    System.out.println("ANSWER: " + res);
  }
}