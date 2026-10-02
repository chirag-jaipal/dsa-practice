package Arrays;

public class MoveZeroes {
  public static void moveZeroes(int nums[]) {
    int n = nums.length;

    int i = 0, j = 0;
    for (; j < n;) {
      if (nums[j] != 0) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        i++;
      }
      j++;
    }
  }

  public static void print(int nums[]) {
    for (int ele : nums) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nums[] = { 0, 1, 0, 3, 12, 0 };
    System.out.print("BEFORE: ");
    print(nums);

    moveZeroes(nums);

    System.out.print("AFTER: ");
    print(nums);
  }
}
