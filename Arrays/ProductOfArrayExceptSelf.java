package Arrays;

public class ProductOfArrayExceptSelf {
  // IDEA: prefix * suffix per ele
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];

    int prefix = 1, suffix = 1;
    for (int i = 0; i < n; i++) {
      output[i] = prefix;
      prefix *= nums[i];
    }

    for (int i = n - 1; i >= 0; i--) {
      output[i] *= suffix;
      suffix *= nums[i];
    }

    return output;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    int[] res = productExceptSelf(nums);

    for (int ele : res) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }
}
