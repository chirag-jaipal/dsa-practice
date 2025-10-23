package MultiDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    // Returns the k-th (0-indexed) row in O(k) time and O(k) space.
    // It uses the mathematical property of combinations (nCr).
    // nCr = nC(r-1) * (n-r+1) / r
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // We use 'long' for the calculation to prevent overflow
        // as intermediate values (nCr * (n-r+1)) can exceed Integer.MAX_VALUE
        long val = 1;

        // Loop 'k+1' times (from 0 to k)
        for (int j = 0; j <= rowIndex; j++) {
            // Add the current combination (kCj) to the row
            row.add((int)val);

            // Calculate the next combination (kC(j+1)) using the current one
            // val = val * (k - j) / (j + 1);
            val = val * (rowIndex - j) / (j + 1);
        }

        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 4;
        List<Integer> row = getRow(rowIndex);
        System.out.println(row); // Output: [1, 4, 6, 4, 1]
    }
}
