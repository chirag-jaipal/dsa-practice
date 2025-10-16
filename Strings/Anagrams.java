package Strings;
import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "allergy";
        String s2 = "allergyy";
        Boolean res = areAnagrams(s1, s2);
        System.out.println(res); // Output: true
        Boolean ans = are_anagrams(s1, s2);
        System.out.println(ans); // Output: true
    }

    // Approach1: Converting string to array
    // Time complexity: O(nlogn)
    // Space Complexity: O(n)
    public static Boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // Approach2: Comparing string's 'chars' with frequency array
    // Time complexity: O(n)
    // Space Complexity: O(1)
    public static Boolean are_anagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        // Create a frequency array for all possible characters (e.g., ASCII)
        int[] charArr = new int[256];

        // Increment count for characters in s1
        for (int i = 0; i < s1.length(); i++)
            charArr[s1.charAt(i)]++;

        // Decrement count for characters in s2
        for (int i = 0; i < s2.length(); i++)
            charArr[s2.charAt(i)]--;

        // If all counts are zero, the strings are anagrams
        for (int count : charArr)
            if (count != 0)
                return false;

        return true;
    }
}
