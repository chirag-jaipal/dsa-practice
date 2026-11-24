package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
  // Approach 1: Brute Force O(n*k) time and O(n-k+1) space
  public static int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i <= nums.length - k; ++i) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < i + k; ++j) {
        if (nums[j] > max) {
          max = nums[j];
        }
      }
      list.add(max);
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  // Approach 2: Monotonic Deque of indexes O(n) time and O(k) space
  public static int[] maxSlidingWindowOptimized(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];
    int idx = 0;

    for (int i = 0; i < nums.length; ++i) {
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }
      deque.offer(i);

      if (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      if (i >= k - 1) {
        res[idx++] = nums[deque.peekFirst()];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 3, 4, 2, 1 };
    int k = 3;
    int[] res = maxSlidingWindowOptimized(nums, k);
    for (int ele : res) {
      System.out.print(ele + " ");
    }
  }
}
