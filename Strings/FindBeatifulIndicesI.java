package Strings;

import java.util.ArrayList;
import java.util.List;

public class FindBeatifulIndicesI {
  // Approach 1: Brute Force have time complexity O(n^2) and space complexity O(1)
  public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
    List<Integer> res = new ArrayList<>();

    for (int i = s.indexOf(a); i != -1; i = s.indexOf(a, i + 1)) {
      if (i <= s.length() - a.length()) {
        for (int j = s.indexOf(b); j != -1; j = s.indexOf(b, j + 1)) {
          if (j <= s.length() - b.length() && Math.abs(j - i) <= k) {
            res.add(i);
            break;
          }
        }
      }
    }

    return res;
  }

  // Approach 2: Using KMP Algorithm have time complexity O(n) and space
  // complexity O(n)
  public static List<Integer> beautifulIndicesV2(String s, String a, String b, int k) {
    List<Integer> res = new ArrayList<>();
    int[] lpsA = computeLPSArray(a);
    int[] lpsB = computeLPSArray(b);

    List<Integer> indicesA = new ArrayList<>();
    List<Integer> indicesB = new ArrayList<>();

    int i = 0, j = 0;
    while (i < s.length()) {
      if (s.charAt(i) == a.charAt(j)) {
        j++;
        i++;
        if (j == a.length()) {
          indicesA.add(i - j);
          j = lpsA[j - 1];
        }
      } else {
        if (j != 0) {
          j = lpsA[j - 1];
        } else {
          i++;
        }
      }
    }

    int x = 0, y = 0;
    while (x < s.length()) {
      if (s.charAt(x) == b.charAt(y)) {
        y++;
        x++;
        if (y == b.length()) {
          indicesB.add(x - y);
          y = lpsB[y - 1];
        }
      } else {
        if (y != 0) {
          y = lpsB[y - 1];
        } else {
          x++;
        }
      }
    }

    int idxB = 0;
    for (int idxA = 0; idxA < indicesA.size(); idxA++) {
      int posA = indicesA.get(idxA);

      while (idxB < indicesB.size()
          && indicesB.get(idxB) < posA - k) {
        idxB++;
      }

      if (idxB < indicesB.size()
          && indicesB.get(idxB) <= posA + k) {
        res.add(posA);
      }
    }

    return res;
  }

  private static int[] computeLPSArray(String pattern) {
    int[] lps = new int[pattern.length()];
    int len = 0;
    int i = 1;

    while (i < pattern.length()) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }

    return lps;
  }

  public static void main(String[] args) {
    String s = "ababababazzabababb";
    String a = "aba";
    String b = "bb";
    int k = 10;
    List<Integer> res = beautifulIndices(s, a, b, k);
    System.out.println(res);
    List<Integer> resV2 = beautifulIndicesV2(s, a, b, k);
    System.out.println(resV2);
  };
}
