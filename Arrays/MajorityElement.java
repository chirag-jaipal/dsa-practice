package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
  // Approach 1: Using Hashmap
  public static int majorityElement(int nums[]) {
    int n = nums.length;
    int appear = n / 2;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        int oldVal = map.get(nums[i]);
        map.replace(nums[i], oldVal, oldVal + 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > appear) {
        return entry.getKey();
      }
    }
    return -1;
  }

  // Approach 2 (Expected): Using Boyer-Moore Voting Algorithm
  public static int majorityEle(int[] nums) {
    int candidate = 0;
    int count = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
        count = 1;
      } else if (num == candidate) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }

  public static void main(String[] args) {
    int nums[] = { 3, 2, 3 };
    System.out.println("MAJORITY ELEMENT: " + majorityElement(nums));
    System.out.println("MAJORITY ELEMENT: " + majorityEle(nums));
  }
}
