public class mergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 6, 9, 20 };
        int[] arr2 = { 1, 3, 4, 5, 7, 8, 90 };

        int[] res = merge(arr1, arr2);
        for (int ele : res)
            System.out.print(ele+" ");
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] ans = new int[n1+n2];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2)
            ans[k++] = (arr1[i] <= arr2[j])? arr1[i++] : arr2[j++];

        // Insert remaining elements of arr1 if present
        while (i < n1)
            ans[k++] = arr1[i++];

        // Insert remaining elements of arr2 if present
        while ( j < n2)
            ans[k++] = arr2[j++];

        return ans;
    }
}
