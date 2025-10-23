package MultiDimentionalArrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {

    // Generates the first n rows of Pascal's Triangle.
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    public static List<List<Integer>> generate(int n) {
        // The main list to hold all the rows
        List<List<Integer>> list = new ArrayList<>();

        // Outer loop iterates for each row (from row 0 to n-1)
        for (int i = 0; i < n; i++) {
            // Create a new list to represent the current row
            list.add(new ArrayList<>());

            // Inner loop iterates for each element in the current row
            // Row 'i' has 'i+1' elements (from j=0 to j=i)
            for (int j = 0; j <= i; j++) {
                // First and last elements of any row are always 1
                if (j == 0 || j == i) {
                    list.get(i).add(1);
                } else {
                    // Calculate the new element by summing the two elements
                    // directly above it from the previous row
                    list.get(i).add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = generate(numRows);
        System.out.println(ans); // Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
