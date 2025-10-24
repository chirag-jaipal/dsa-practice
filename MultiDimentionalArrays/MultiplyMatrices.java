package MultiDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class MultiplyMatrices {

    // Multiplies two square matrices 'a' and 'b'.
    // Note: This code assumes both 'a' and 'b' are n x n square matrices.
    public static List<List<Integer>> multiply(int[][] a, int[][] b) {
        // Initialize the resulting list of lists.
        List<List<Integer>> ans = new ArrayList<>();

        // Get the size 'n' (number of rows, assuming a square matrix).
        int n = a.length;

        // Outer loop: Iterate through each row 'i' of the result matrix.
        for (int i = 0; i < n; i++) {
            // Add a new empty row to the result list.
            ans.add(new ArrayList<>());

            // Middle loop: Iterate through each column 'j' of the result matrix.
            for (int j = 0; j < n; j++) {

                // 'sum' will store the dot product for the cell (i, j).
                int sum = 0;

                // Inner loop: Calculate the dot product of row 'i' from 'a' and column 'j' from 'b'.
                for (int k = 0; k < n; k++) {
                    // Accumulate the product: ans[i][j] = a[i][k] * b[k][j]
                    sum += a[i][k] * b[k][j];
                }

                // Add the calculated dot product to the current row 'i' of the result matrix.
                ans.get(i).add(sum);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // Define two 3x3 test matrices.
        int[][] mat1 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[][] mat2 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

        // Call the multiply function.
        List<List<Integer>> mat = multiply(mat1, mat2);

        // Print the resulting matrix.
        System.out.println(mat);
    }
}
