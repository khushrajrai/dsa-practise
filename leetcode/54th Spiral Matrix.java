// 54. Spiral Matrix

// Given an m x n matrix, return all elements of the matrix in spiral order.
// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = m - 1;
        while (startRow <= endRow && startCol <= endCol) {
            //first row
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow += 1;
            //end column
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol -= 1;
            //last row
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
                endRow -= 1;
            }
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                startCol += 1;
            }
        }
        return result;
    }
}
