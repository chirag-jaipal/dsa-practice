package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumCandiesAllocatedToKChildren {
  // Approach 1: Binary Search
  public static int maximumCandies(int[] candies, long k) {
    int low = 1, high = 0;

    for (int pile : candies) {
      high = Math.max(pile, high);
    }

    int maxCandiesAlloted = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      long child = 0;

      for (int pile : candies) {
        child += pile / mid;
      }

      if (child >= k) {
        low = mid + 1;
        maxCandiesAlloted = mid;
      } else {
        high = mid - 1;
      }
    }

    return maxCandiesAlloted;
  }

  // Approach 2: Heap (Priority Queue) (Relatively Slower)
  public static int maxCandies(int[] candies, long k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int pile : candies) {
      maxHeap.offer(pile);
    }
    int maxPile = maxHeap.peek();

    for (int size = maxPile; size >= 1; size--) {
      long count = 0;
      for (int pile : candies) {
        count += pile / size;
      }
      if (count >= k) {
        return size;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] candies = { 5, 8, 6 };
    System.out.println("RESULT: " + maximumCandies(candies, 3));
  }
}
