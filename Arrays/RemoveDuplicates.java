package Arrays;

public class RemoveDuplicates {
  public static int removeDuplicates(int[] nums) {
    int n = nums.length;

    int i, j;
    for (i = 0, j = 1; j < n; j++) {
      if (nums[i] != nums[j]) {
        nums[++i] = nums[j];
      }
    }

    return i + 1;
  }

  public static void print(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

    System.out.println("BEFORE: ");
    print(nums);
    int res = removeDuplicates(nums);

    System.out.println("AFTER: ");
    print(nums);

    System.out.println(res);
  }
}
