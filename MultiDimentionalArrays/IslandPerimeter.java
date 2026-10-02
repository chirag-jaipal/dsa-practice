package MultiDimentionalArrays;

public class IslandPerimeter {
  public static int islandPerimeter(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int perimeter = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          // TOP
          if (i == 0 || grid[i - 1][j] == 0) {
            perimeter += 1;
          }

          // RIGHT
          if (j == col - 1 || grid[i][j + 1] == 0) {
            perimeter += 1;
          }

          // BOTTOM
          if (i == row - 1 || grid[i + 1][j] == 0) {
            perimeter += 1;
          }

          // LEFT
          if (j == 0 || grid[i][j - 1] == 0) {
            perimeter += 1;
          }
        }
      }
    }

    return perimeter;
  }

  public static void main(String[] args) {
    int[][] grid1 = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
    int[][] grid2 = { { 1 } };
    int[][] grid3 = { { 1, 0 } };

    System.out.println("RESULT: " + islandPerimeter(grid1));
    System.out.println("RESULT: " + islandPerimeter(grid2));
    System.out.println("RESULT: " + islandPerimeter(grid3));
  }
}
