package Stack;

public class DecodeString {
  // Approach 1: Using Recursion O(n) time and O(n) space
  private static String decode(String s, int[] idx) {
    StringBuilder res = new StringBuilder();

    while (idx[0] < s.length()) {
      char ch = s.charAt(idx[0]);

      if (Character.isDigit(ch)) {
        int num = 0;
        while (idx[0] < s.length() &&
            Character.isDigit(s.charAt(idx[0]))) {
          num = num * 10 + (s.charAt(idx[0]) - '0');
          idx[0]++;
        }
        idx[0]++;

        String decoded = decode(s, idx);
        res.append(decoded.repeat(num));
      } else if (ch == ']') {
        idx[0]++;
        return res.toString();
      } else {
        res.append(ch);
        idx[0]++;
      }
    }
    return res.toString();
  }

  public static String decodeString(String s) {
    return decode(s, new int[] { 0 });
  }

  public static void main(String[] args) {
    String s = "2[abc]3[cd]ef";
    System.out.println("RESULT: " + decodeString(s));
  }
}
