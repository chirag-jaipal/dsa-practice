package Strings;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
  private static void restoreHelper(String s, int start, List<String> ipParts, List<String> result) {
    if (ipParts.size() == 4) {
      if (start == s.length()) {
        result.add(String.join(".", ipParts));
      }
      return;
    }

    for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
      String segment = s.substring(start, start + len);

      if (segment.length() > 1 && segment.charAt(0) == '0') {
        break;
      }

      if (Integer.parseInt(segment) <= 255) {
        ipParts.add(segment);
        restoreHelper(s, start + len, ipParts, result);
        ipParts.remove(ipParts.size() - 1);
      }
    }
  }

  public static List<String> restoreIPAddress(String s) {
    List<String> result = new ArrayList<>();
    if (s.length() < 4 || s.length() > 12) {
      return result;
    }

    List<String> ipParts = new ArrayList<>();
    restoreHelper(s, 0, ipParts, result);
    return result;
  }

  public static void main(String[] args) {
    String s = "19216811";
    List<String> ipAddresses = restoreIPAddress(s);
    System.out.println(ipAddresses);
  }
}
