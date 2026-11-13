package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  // Approach 1: Using sorting O(nlogn) time
  public static int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int streak = 1, best = 1;

    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1] + 1) {
        streak++;
      } else if (nums[i] != nums[i - 1]) {
        streak = 1;
      }
      best = Math.max(streak, best);
    }
    return best;
  }

  // Approach 2: Using Set O(n) time and space
  public static int longestConsecutiveV2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int best = 0;
    for (int num : set) {
      if (set.contains(num - 1))
        continue;

      int length = 1;
      while (set.contains(num + length)) {
        length++;
      }
      best = Math.max(best, length);
    }
    return best;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 0, 1, 2 };
    System.out.println("RESULT: " + longestConsecutive(nums));
    System.out.println("RESULT: " + longestConsecutiveV2(nums));
  }
}
