package Strings;

public class NumberOfLaserBeams {
  // Approach 1: Using extra auxiliary space
  public static int numberOfBeams(String[] bank) {
    int[] secDeviceCount = new int[bank.length];

    for (int i = 0; i < bank.length; i++) {
      for (int j = 0; j < bank[i].length(); j++) {
        if (bank[i].charAt(j) == '1') {
          secDeviceCount[i]++;
        }
      }
    }

    int beams = 0;
    int i = 0, j = 1;
    while (j < secDeviceCount.length) {
      if (secDeviceCount[j] != 0) {
        beams += secDeviceCount[i] * secDeviceCount[j];
        i = j;
      }
      j++;
    }

    return beams;
  }

  // Approach 2: Without using extra space
  public static int numberOfLaserBeams(String[] bank) {
    int beams = 0;
    int prev = 0, curr = 0;

    for (int i = 0; i < bank.length; ++i) {
      for (int j = 0; j < bank[i].length(); j++) {
        if (bank[i].charAt(j) == '1') {
          curr += 1;
        }
      }

      beams += prev * curr;
      if (curr != 0) {
        prev = curr;
        curr = 0;
      }
    }

    return beams;
  }

  public static void main(String[] args) {
    String[] bank = { "011001", "000000", "010100", "001000" };
    System.out.println("BEAMS: " + numberOfBeams(bank));
    System.out.println("BEAMS: " + numberOfLaserBeams(bank));
  }
}
