import java.util.Collections;
import java.util.Vector;

public class addingOne {

    public static Vector<Integer> addOne(int[] arr) {
        Vector<Integer> newArr = new Vector<>();
        int n = arr.length;

        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] += carry;
            newArr.add(arr[i] % 10);
            carry = arr[i] / 10;
        }
        if (carry == 1) newArr.add(1); // If 'carry = 1' after loop termination

        Collections.reverse(newArr);
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 9, 9 };
        Vector<Integer> ans = addOne(arr);
        System.out.print(ans + " ");
    }
}
