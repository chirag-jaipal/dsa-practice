package Strings;

public class SentenceIsPangram {
  public static boolean isPangram(String sentence) {
    int[] freq = new int[26];

    for (int i = 0; i < sentence.length(); i++) {
      freq[sentence.charAt(i) - 'a']++;
    }

    for (int i = 0; i < freq.length; i++) {
      if (freq[i] == 0)
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String sentence = "thequickbrownfoxjumpsoverthelazydog";
    System.out.println("RESULT: " + isPangram(sentence));
  }
}
