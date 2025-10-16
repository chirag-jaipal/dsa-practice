package Strings;

import java.util.Arrays;

public class MostFrequentChar {
    public static void main(String[] args) {
        String s = "output";
        char res = maxOccuringChar(s);
        System.out.println(res);
        char ans = max_occuringn_char(s);
        System.out.println(ans);
    }

    // Approach1: Frequency Count array
    // Time-Complexity: O(n)
    // Space-Complexity: O(1)
    public static char maxOccuringChar(String s) {
        int[] charArr = new int[128];

        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i)]++;
        }

        int maxOccur = 0;
        int idx = -1;
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] >= maxOccur) {
                maxOccur = charArr[i];
                idx = i;
            }
        }

        return (char) idx;
    }

    // Approach2: Sliding Window
    // Time-Complexity: O(nlogn)
    // Space-Complexity: O(n)
    public static char max_occuringn_char(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int maxfreq = -1;
        char ans = arr[0];
        int count = 0;
        int i, j;
        for (i = 0, j = 0; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                count = j - i;
                if (count > maxfreq) {
                    maxfreq = count;
                    ans = arr[i];
                }
                i = j;
            }
        }
        if (maxfreq < count) {
            maxfreq = count;
            ans = arr[i];
        }
        
        return ans;
    }
}
