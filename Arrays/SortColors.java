package Arrays;

public class SortColors {

  // Approach 1: Counting Sort
  public static void sortUsingCountingSort(int[] nums) {
    int n = nums.length;
    int[] count = new int[3];

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        count[0]++;
      } else if (nums[i] == 1) {
        count[1]++;
      } else {
        count[2]++;
      }
    }

    for (int i = 0; i < count[0]; i++) {
      nums[i] = 0;
    }

    for (int i = count[0]; i < count[0] + count[1]; i++) {
      nums[i] = 1;
    }

    for (int i = count[1] + count[0]; i < n; i++) {
      nums[i] = 2;
    }
  }

  // Approach 2: Two Pass
  public static void sortUsingTwoPass(int[] nums) {
    int n = nums.length;

    int write = 0; // indicates the position where next 0 should come
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        swap(nums, write, i);
        write++;
      }
    }

    int back = n - 1; // indicates the position where next 2 should come
    int i = write;
    while (i <= back) {
      if (nums[i] == 2) {
        swap(nums, back, i);
        back--;
      } else {
        i++;
      }
    }
  }

  // Approach 3: 1 Pass (Dutch National Flag)
  public static void sortColors(int[] nums) {
    int n = nums.length;
    int low = 0, mid = 0, high = n - 1;

    while (mid <= high) {
      if (nums[mid] == 1) {
        mid++;
      } else if (nums[mid] == 0) {
        swap(nums, low, mid);
        low++;
        mid++;
      } else {
        swap(nums, mid, high);
        high--;
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void print(int[] arr) {
    for (int ele : arr) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = { 2, 0, 2, 1, 1, 0 };
    System.out.println("BEFORE: ");
    print(nums);

    // sortColors(nums);
    // sortUsingCountingSort(nums);
    sortUsingTwoPass(nums);
    System.out.println("AFTER: ");
    print(nums);
  }
}
