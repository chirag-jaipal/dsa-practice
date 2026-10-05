package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestNumber {
  // Approach 1: Using Maxheap
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int ele : nums) {
      maxHeap.add(ele);
    }

    int answer = nums[0];
    for (int i = 0; i < k; i++) {
      answer = maxHeap.remove();
    }

    return answer;
  }

  // Approach 2: Using Minheap
  public static int findKthLargestEle(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int ele : nums) {
      if (minHeap.size() < k) {
        minHeap.add(ele);
      } else if (minHeap.peek() < ele) {
        minHeap.remove();
        minHeap.add(ele);
      }
    }

    return minHeap.peek();
  }

  public static void main(String[] args) {
    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k = 4;
    System.out.println("ANSWER1: " + findKthLargest(nums, k));
    System.out.println("ANSWER2: " + findKthLargestEle(nums, k));
  }
}
