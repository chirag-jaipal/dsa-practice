public class secondMax {
    public static void main(String[] args) {
        int[] arr = { 9, 9, 9, 9, 9 };
        int res = second_max(arr);

        if (res != -1) 
            System.out.println(res);
        else
            System.out.println("No second max found.");
    }

    public static int second_max(int[] arr) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        
        if (secondLargest != Integer.MIN_VALUE)
             return secondLargest;
        else
             return -1;
    }
}
