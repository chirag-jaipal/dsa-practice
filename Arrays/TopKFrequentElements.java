package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
  // Approach 1: Count + Sorting ; O(nlogn) time and O(n) space
  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> count = new HashMap<>();

    for (int ele : nums)
      if (count.containsKey(ele))
        count.put(ele, count.get(ele) + 1);
      else
        count.put(ele, 1);

    List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(count.entrySet());
    entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

    int[] res = new int[k];
    for (int i = 0; i < k; ++i)
      res[i] = entries.get(i).getKey();

    return res;
  }

  // Approach 2: Count + Bucket Sort ; O(n) time and O(n) space
  public static int[] topKFrequentV2(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] buckets = new List[nums.length + 1];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<>();
    }

    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      buckets[entry.getValue()].add(entry.getKey());
    }

    int[] result = new int[k];
    int index = 0;
    for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
      for (int num : buckets[i]) {
        result[index++] = num;
        if (index == k)
          break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
    int k = 2;
    int[] res = topKFrequentV2(nums, k);
    System.out.println("ELE1: " + res[0] + "\nELE2: " + res[1]);
  }
}
