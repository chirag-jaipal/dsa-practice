package Arrays;

import java.util.HashMap;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int need = target - nums[i];
      if (map.containsKey(need)) {
        return new int[] { map.get(need), i };
      }
      map.put(nums[i], i);
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    int[] nums = { 3, 8, 2, 5 };
    int target = 10;
    int[] res = twoSum(nums, target);
    System.out.println("INDEX1: " + res[0] + " , INDEX2: " + res[1]);
  }
}
