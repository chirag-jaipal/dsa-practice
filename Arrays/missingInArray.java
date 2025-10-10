public class missingInArray {

    // Approach1: XOR trick
    public static int missingEle(int[] arr) {
        int n = arr.length;
        int xor1 = 0, xor2 = 0;
        for (int i = 1; i <= n+1; i++) {
            xor1 ^= i;
        }

        for (int i : arr) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }

    // Appraoch2: Difference of sum
    public static int missing_ele(int[] arr) {
        long n = arr.length;
        long sum = ((n+1) * (n+2)) / 2;

        long arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += arr[i];
        }
        return (int)(sum - arraySum);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int ele = missingEle(arr);
        int res = missing_ele(arr);
        
        System.out.println(res);
        System.out.println(ele);
    }
}
