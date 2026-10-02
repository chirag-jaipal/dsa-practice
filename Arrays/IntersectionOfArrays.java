package Arrays;

import java.util.HashSet;

public class IntersectionOfArrays {
  public static int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    for (int ele : nums1) {
      set.add(ele);
    }

    HashSet<Integer> result = new HashSet<>();
    for (int ele : nums2) {
      if (set.contains(ele)) {
        result.add(ele);
      }
    }

    int resArr[] = new int[result.size()];
    int i = 0;
    for (int ele : result) {
      resArr[i++] = ele;
    }

    return resArr;
  }

  public static void main(String[] args) {
    int nums1[] = { 4, 9, 5 };
    int nums2[] = { 9, 4, 9, 8, 4 };
    int result[] = intersection(nums1, nums2);

    for (int ele : result) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }
}