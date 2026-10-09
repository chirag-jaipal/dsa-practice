package Arrays;

public class CountNumberOfInversions {
  private static int mergeSort(int[] nums, int low, int high) {
    if (low >= high) {
      return 0;
    }

    int mid = low + (high - low) / 2;
    int count = 0;

    count += mergeSort(nums, low, mid);
    count += mergeSort(nums, mid + 1, high);

    int[] temp = new int[high - low + 1];
    int i = low, j = mid + 1, k = 0;

    while (i <= mid && j <= high) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        count += (mid - i + 1);
        temp[k++] = nums[j++];
      }
    }

    while (i <= mid)
      temp[k++] = nums[i++];

    while (j <= high)
      temp[k++] = nums[j++];

    for (int t = 0; t < temp.length; t++) {
      nums[low + t] = temp[t];
    }

    return count;
  }

  public static int numberOfInverstions(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] nums = { 2, 4, 1, 3, 5 };
    System.out.println("RESULT: " + numberOfInverstions(nums));
  }
}
