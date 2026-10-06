package Arrays;

public class rotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int idx1, int idx2) {
        while (idx1 < idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++;
            idx2--;
        }
    }

    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { -1, -100, 3, 99 };
        int k = 2;

        System.out.println("BEFORE: ");
        print(arr);

        rotate(arr, k);

        System.out.println("AFTER: ");
        print(arr);
    }
}
