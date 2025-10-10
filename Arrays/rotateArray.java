public class rotateArray {

    // Function to rotate array
    public static void rotate_array(int[] arr, int d) {
        int n = arr.length;
        d %= n;
        reverse_array(arr, 0, d-1);
        reverse_array(arr, d, n-1);
        reverse_array(arr, 0, n-1);
    }

    // Function to reverse array (Two-Pointer Approach)
    private static void reverse_array(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Function to print array
    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int d = 2;
        rotate_array(arr, d);
        print(arr);
    }
}
