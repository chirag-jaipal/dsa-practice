package Strings;

public class DeleteColumnsToMakeSorted {
  public static int minDeletionSize(String[] strs) {
    int count = 0;

    for (int i = 0; i < strs[0].length(); i++) {
      for (int j = 0; j < strs.length - 1; j++) {
        if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
          count++;
          break;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    String[] str = { "zyx", "wvu", "tsr" };
    System.out.println("RESULT: " + minDeletionSize(str));
  }
}
