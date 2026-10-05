package MultiDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Traverses a 2D matrix in a spiral pattern.
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> order = new ArrayList<>();

        int top = 0;
        int right = col - 1;
        int bottom = row - 1;
        int left = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                order.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                order.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    order.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    order.add(matrix[i][left]);
                }
                left++;
            }
        }

        return order;
    }

    public static void main(String[] args) {
        // Test a square case
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> order = spiralOrder(mat);
        System.out.println(order); // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Test a non-square case
        int[][] mat2 = { { 1, 2, 3, 4 } };
        List<Integer> order2 = spiralOrder(mat2);
        System.out.println(order2); // Expected: [1, 2, 3, 4]
    }
}
