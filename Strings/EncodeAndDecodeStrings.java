package Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
  public static String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String word : strs) {
      sb.append(word.length()).append("#").append(word);
    }
    return sb.toString();
  }

  public static List<String> decode(String str) {
    List<String> decode = new ArrayList<>();

    int ptr = 0;
    while (ptr < str.length()) {
      int j = ptr;
      while (str.charAt(j) != '#') {
        j++;
      }

      int len = Integer.parseInt(str.substring(ptr, j));
      decode.add(str.substring(j + 1, j + 1 + len));
      ptr = j + 1 + len;
    }
    return decode;
  }

  public static void main(String[] args) {
    List<String> strs = List.of("");
    String str = encode(strs);
    System.out.println("ORIGINAL STRING: " + strs);
    System.out.println("ENCODED STRING: " + str);
    System.out.println("DECODED STRING: " + decode(str));
  }
}
