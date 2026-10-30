package Strings;

public class CountHomogenuousSubstrings {
  // Approach 1
  static int countHomogenous(String s) {
    long count = 0;
    int i = 0;

    for (int j = 0; j < s.length(); ++j) {
      if (s.charAt(i) != s.charAt(j)) {
        long len = j - i;
        count += ((len * (len + 1)) / 2) % 1_000_000_007;
        i = j;
      }
    }

    long len = s.length() - i;
    count += ((len * (len + 1)) / 2) % 1_000_000_007;

    return (int) count;
  }

  // Approach 2
  static int countHomogenousV2(String s) {
    long count = 0;
    long streak = 0;
    int MOD = 1_000_000_007;

    char prev = '\0';

    for (char c : s.toCharArray()) {
      if (c == prev) {
        streak++;
      } else {
        streak = 1;
        prev = c;
      }

      count = (count + streak) % MOD;
    }

    return (int) count;
  }

  public static void main(String[] args) {
    String s = "zzzzz";
    System.out.println("RESULT: " + countHomogenous(s));
    System.out.println("RESULT: " + countHomogenousV2(s));
  }
}
