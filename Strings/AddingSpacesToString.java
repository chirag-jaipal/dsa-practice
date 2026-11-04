package Strings;

public class AddingSpacesToString {
  // Approach 1: Naive (Brute Force) | Time O(n + k), Space O(n + k)
  static String addSpaces(String s, int[] spaces) {
    StringBuilder sb = new StringBuilder(s.length() + spaces.length);

    int curr = 0;
    for (int next = 0; next < spaces.length; ++next) {
      sb.append(s.substring(curr, spaces[next])).append(" ");
      curr = spaces[next];
    }

    sb.append(s.substring(curr, s.length()));

    return sb.toString();
  }

  // Approach 2: Time O(n + k), Space O(n)
  static String addSpacesV2(String s, int[] spaces) {
    StringBuilder res = new StringBuilder(s.length() + spaces.length);

    int idx = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (idx != spaces.length && i == spaces[idx]) {
        res.append(" ").append(s.charAt(i));
        idx++;
      } else {
        res.append(s.charAt(i));
      }
    }

    return res.toString();
  }

  // Approach 3: Time O(n + k), Space O(n)
  static String addSpacesV3(String s, int[] spaces) {
    StringBuilder res = new StringBuilder(s.length() + spaces.length);

    int idx = 0;
    for (int i = 0; i < spaces.length; ++i) {
      while (idx < spaces[i]) {
        res.append(s.charAt(idx++));
      }
      res.append(" ");
    }

    while (idx < s.length()) {
      res.append(s.charAt(idx++));
    }

    return res.toString();
  }

  public static void main(String[] args) {
    String s = "spacing";
    int[] spaces = { 0, 1, 2, 3, 4, 5, 6 };
    System.out.println("RESULT: " + addSpaces(s, spaces));
    System.out.println("RESULT: " + addSpacesV2(s, spaces));
    System.out.println("RESULT: " + addSpacesV3(s, spaces));
  }
}
