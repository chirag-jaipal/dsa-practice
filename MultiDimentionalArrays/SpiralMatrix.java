package MultiDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Traverses a 2D matrix in a spiral pattern.
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    public static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> order = new ArrayList<>();
        int m = mat.length, n = mat[0].length;

        // Define the four boundaries of the "layer" we are currently traversing.
        int firstRow = 0, firstCol = 0;
        int lastRow = m - 1, lastCol = n - 1;

        // Keep looping as long as the boundaries have not crossed.
        while (firstRow <= lastRow && firstCol <= lastCol) {

            // 1. Traverse the Top Row (left to right)
            for (int j = firstCol; j <= lastCol; j++) {
                order.add(mat[firstRow][j]);
            }
            firstRow++; // Move the top boundary down.

            // 2. Traverse the Right Column (top to bottom)
            for (int i = firstRow; i <= lastRow; i++) {
                order.add(mat[i][lastCol]);
            }
            lastCol--; // Move the right boundary left.

            // 3. Traverse the Bottom Row (right to left)
            // We must check if the boundaries have crossed (for single-row matrices)
            if (firstRow <= lastRow) {
                for (int j = lastCol; j >= firstCol; j--) {
                    order.add(mat[lastRow][j]);
                }
            }
            lastRow--; // Move the bottom boundary up.

            // 4. Traverse the Left Column (bottom to top)
            // We must check if the boundaries have crossed (for single-column matrices)
            if (firstCol <= lastCol) {
                for (int i = lastRow; i >= firstRow; i--) {
                    order.add(mat[i][firstCol]);
                }
            }
            firstCol++; // Move the left boundary right.
        }

        return order;
    }
    
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> order = spiralOrder(mat);
        System.out.println(order); // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Test a non-square case
        int[][] mat2 = {{1, 2, 3, 4}};
        List<Integer> order2 = spiralOrder(mat2);
        System.out.println(order2); // Expected: [1, 2, 3, 4]
    }
}
