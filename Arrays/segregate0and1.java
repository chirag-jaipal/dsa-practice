public class segregate0and1 {

    // One Pass Approach
    public static void segregateArray(int[] arr) {
        int n = arr.length;

        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                arr[i] = 0;
                arr[j] = 1;
                i++;
                j--;
            } else if (arr[j] == 1)
                j--;
            else if (arr[i] == 0)
                i++;
        }
    }

    // Two Pass Approach
    public static void segregate_array(int[] arr) {
        int n = arr.length;

        int countZeroes = 0;
        for (int ele : arr) {
            if (ele == 0)
                countZeroes++;
        }

        for (int i = 0; i < countZeroes; i++) {
            arr[i] = 0;
        }

        for (int i = countZeroes; i < n; i++) {
            arr[i] = 1;
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
        int[] arr = { 0, 0, 0, 1, 0, 1, 1 };
        segregateArray(arr);
        print(arr);
        segregate_array(arr);
        print(arr);
    }
}
