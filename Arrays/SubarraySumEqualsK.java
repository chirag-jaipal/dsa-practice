package Arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
  public static int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int count = 0;
    int currPrefixSum = 0;
    for (int ele : nums) {
      currPrefixSum += ele;

      if (map.containsKey(currPrefixSum - k)) {
        count += map.get(currPrefixSum - k);
      }

      map.put(currPrefixSum, map.getOrDefault(currPrefixSum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    int k = 3;
    System.out.println("RESULT: " + subarraySum(nums, k));
  }
}
