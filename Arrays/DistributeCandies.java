package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class DistributeCandies {
  // Approach 1: Sorting
  public static int distributeCandies(int[] candytype) {
    int n = candytype.length;
    Arrays.sort(candytype);

    int advice = n / 2;

    int count = 1;
    for (int i = 1; i < n; i++) {
      if (candytype[i] != candytype[i - 1]) {
        if (count >= advice) {
          break;
        } else {
          count++;
        }
      }
    }

    return count;
  }

  // Approach 2: HashSet
  public static int distributeCandy(int[] candyType) {
    int n = candyType.length;
    HashSet<Integer> set = new HashSet<>();

    for (int candy : candyType) {
      set.add(candy);
    }

    return Math.min(set.size(), n / 2);
  }

  public static void main(String[] args) {
    int[] candyType = { 1, 1, 2, 3 };
    System.out.println("RESULT1: " + distributeCandies(candyType));
    System.out.println("RESULT2: " + distributeCandy(candyType));
  }
}
