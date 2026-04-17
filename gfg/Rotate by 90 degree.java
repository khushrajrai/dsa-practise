// Rotate by 90 degree

// Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 
// Examples:
// Input: mat[][] = [[0, 1, 2], 
//                 [3, 4, 5], 
//                 [6, 7, 8]] 
// Output: [[2, 5, 8],
//         [1, 4, 7],
//         [0, 3, 6]]
// Input: mat[][] = [[1, 2],
//                 [3, 4]]
// Output: [[2, 4],
//         [1, 3]]
// Constraints:
// 1 ≤ n ≤ 102
// 0 ≤ mat[i][j] ≤ 103
class Solution {

    public void rotateMatrix(int[][] matrix) {
        transpose(matrix);
        int n = matrix.length;
        //reverse rows - for clockwise and swap rows - for anti-clockwise
        //here we have to rotate clockwise
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
