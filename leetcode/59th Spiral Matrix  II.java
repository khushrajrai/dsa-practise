// 59. Spiral Matrix II

// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
// Example 1:
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:
// Input: n = 1
// Output: [[1]]
// Constraints:
// 1 <= n <= 20
class Solution {

    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        int val = 1;
        while (startRow <= endRow && startCol <= endCol) {
            //first row
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = val;
                val++;
            }
            startRow += 1;
            //last column
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = val;
                val++;
            }
            endCol -= 1;
            //last row
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    matrix[endRow][j] = val;
                    val++;
                }
                endRow -= 1;
            }
            //first column
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    matrix[i][startCol] = val;
                    val++;
                }
                startCol += 1;
            }
        }
        return matrix;
    }
}
