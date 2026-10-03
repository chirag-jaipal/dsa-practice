package Arrays;

import java.util.ArrayList;
import java.util.Collections;

class ScoreWithIndex implements Comparable<ScoreWithIndex> {
  int score;
  int index;

  public ScoreWithIndex(int score, int index) {
    this.score = score;
    this.index = index;
  }

  @Override
  public int compareTo(ScoreWithIndex athlete) {
    return Integer.compare(athlete.score, this.score);
  }
}

public class RelativeRanks {
  // Approach 1: Nested Loops
  public static String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] result = new String[n];

    for (int i = 0; i < n; i++) {
      int count = 0;
      int currAthleteScore = score[i];

      for (int j = 0; j < n; j++) {
        if (score[j] > currAthleteScore) {
          count++;
        }
      }

      if (count == 0) {
        result[i] = "Gold Medal";
      } else if (count == 1) {
        result[i] = "Silver Medal";
      } else if (count == 2) {
        result[i] = "Bronze Medal";
      } else {
        result[i] = Integer.toString(count + 1);
      }
    }

    return result;
  }

  // Approach 2: O(nlogn)
  public static String[] findRelativeRanksV2(int[] score) {
    int n = score.length;
    ArrayList<ScoreWithIndex> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new ScoreWithIndex(score[i], i));
    }

    Collections.sort(list);

    String[] result = new String[n];
    for (int rank = 0; rank < n; rank++) {
      int athlete = list.get(rank).index;
      result[athlete] = rank == 0 ? "Gold Medal"
          : rank == 1 ? "Silver Medal"
              : rank == 2 ? "Bronze Medal"
                  : Integer.toString(rank + 1);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] score = { 10, 3, 8, 9, 4 };
    String[] result = findRelativeRanks(score);
    String[] res = findRelativeRanksV2(score);

    for (String str : result) {
      System.out.print(str + " ");
    }
    System.out.println();

    for (String str : res) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}
