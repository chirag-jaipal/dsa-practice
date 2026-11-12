package Arrays;

import java.util.HashSet;

public class ContainsDuplicate {
  static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int ele : nums) {
      if (set.contains(ele)) {
        return true;
      }
      set.add(ele);
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    System.out.println("RESULT: " + containsDuplicate(nums));
  }
}
