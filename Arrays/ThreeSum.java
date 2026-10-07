package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
  // Approach 1: HashSet
  public static List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();

    Set<List<Integer>> triplets = new HashSet<>();

    for (int i = 0; i < n - 1; i++) {
      Set<Integer> set = new HashSet<>();

      for (int j = i + 1; j < n; j++) {
        int need = -(nums[i] + nums[j]);

        if (set.contains(need)) {
          List<Integer> triplet = Arrays.asList(nums[i], nums[j], need);
          triplet.sort(Integer::compareTo);
          triplets.add(triplet);
        }

        set.add(nums[j]);
      }
    }

    result.addAll(triplets);
    return result;
  }

  // Approach 2: Sort + Two Pointers (Expected)
  public static List<List<Integer>> threeSumSolution(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      int left = i + 1, right = n - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));

          while (left < right && nums[left] == nums[left + 1])
            left++;

          while (left < right && nums[right] == nums[right - 1])
            right--;

          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = threeSum(nums);
    // List<List<Integer>> result = threeSumSolution(nums);

    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
}
