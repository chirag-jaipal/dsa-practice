package MultiDimentionalArrays;

import java.util.ArrayList;

public class TransposeMatrix {

    // Creates a new transposed matrix from the input matrix.
    // The original matrix's columns become the new matrix's rows.
    public static ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // Initialize the result list that will hold the new rows.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // The outer loop iterates over the COLUMNS of the original matrix.
        // mat[0].length gives the number of columns.
        for (int j = 0; j < mat[0].length; j++) {
            // Create a new empty list to represent a new ROW in the transposed matrix.
            ans.add(new ArrayList<>());

            // The inner loop iterates over the ROWS of the original matrix.
            for (int i = 0; i < mat.length; i++) {
                // Get the new row (which corresponds to the original column 'j').
                // Add the element mat[i][j] to it.
                // This flips the (i, j) element to a (j, i) position in the new matrix.
                ans.get(j).add(mat[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { { 2, 8, 3, 4 }, { 7, 2, 1, 6 }, { 5, 5, 4, 1 }, { 3, 1, 8, 2 } };

        // Call the transpose function to get the result.
        ArrayList<ArrayList<Integer>> res = transpose(mat);

        // --- Print the transposed matrix ---
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
