package Arrays;

public class PeakIndexInMountainArray {
  public static int peakIndexInMountainArray(int[] arr) {
    int n = arr.length;
    int left = 0, right = n - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }

    return left;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 6, 9, 12, 8, 4, 2 };
    System.out.println("PEAK INDEX: " + peakIndexInMountainArray(arr));
  }
}
