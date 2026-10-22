package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
  private static Boolean isConcatenated(String word, HashSet<String> set, HashMap<String, Boolean> map) {
    if (map.containsKey(word)) {
      return map.get(word);
    }

    for (int i = 1; i < word.length(); i++) {
      String prefix = word.substring(0, i);
      String suffix = word.substring(i);

      if (set.contains(prefix)) {
        if (set.contains(suffix) || isConcatenated(suffix, set, map)) {
          map.put(word, true);
          return true;
        }
      }
    }

    map.put(word, false);
    return false;
  }

  public static List<String> findAllConcatenatedWordsInADict(String[] words) {
    HashSet<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }

    HashMap<String, Boolean> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    for (String word : words) {
      if (isConcatenated(word, set, map)) {
        res.add(word);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
    List<String> result = findAllConcatenatedWordsInADict(words);
    System.out.println(result);
  }
}
