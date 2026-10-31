package Strings;

import java.util.Arrays;

public class SortVowels {
  static boolean isVowel(char c) {
    char ch = Character.toLowerCase(c);
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
      return true;
    }
    return false;
  }

  // Approach 1: Using Nested Loops + Swap
  static String sortVowels(String s) {
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < sb.length() - 1; ++i) {
      if (!isVowel(s.charAt(i))) {
        continue;
      }

      int small = i;
      for (int j = i + 1; j < sb.length(); ++j) {
        if (isVowel(sb.charAt(j)) && (sb.charAt(j) < sb.charAt(small))) {
          small = j;
        }
      }

      char charI = sb.charAt(i);
      char charSmall = sb.charAt(small);
      sb.setCharAt(i, charSmall);
      sb.setCharAt(small, charI);
    }

    return sb.toString();
  }

  // Approach 2: Using Nested Loops + Sort
  static String sortVowelsV2(String s) {
    char[] arr = s.toCharArray();
    StringBuilder sb = new StringBuilder();

    Arrays.sort(arr);

    int j = 0;
    for (int i = 0; i < s.length(); ++i) {
      char currChar = s.charAt(i);

      if (isVowel(currChar)) {
        while (j < arr.length) {
          if (isVowel(arr[j])) {
            sb.append(arr[j++]);
            break;
          }
          j++;
        }
      } else {
        sb.append(currChar);
      }
    }

    return sb.toString();
  }

  // Approach 3: Using Frequency Count
  static String sortVowelsV3(String s) {
    int[] freq = new int[123];
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (isVowel(c)) {
        freq[c]++;
      }
    }

    int j = 0;
    for (int i = 0; i < s.length(); ++i) {
      char currChar = s.charAt(i);

      if (isVowel(currChar)) {
        while (j < freq.length) {
          if (freq[j] > 0) {
            sb.append((char) j);
            freq[j]--;
            break;
          }
          j++;
        }
      } else {
        sb.append(currChar);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "UpjPbEnOj";
    System.out.println("RESULT: " + sortVowels(s));
    System.out.println("RESULT: " + sortVowelsV2(s));
    System.out.println("RESULT: " + sortVowelsV3(s));
  }
}
