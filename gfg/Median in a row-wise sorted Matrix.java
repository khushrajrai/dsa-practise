// Median in a row-wise sorted Matrix

// Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.
// Examples:
// Input: mat[][] = [[1, 3, 5], 
//                 [2, 6, 9], 
//                 [3, 6, 9]]
// Output: 5
// Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
// Input: mat[][] = [[2, 4, 9],
//                 [3, 6, 7],
//                 [4, 7, 10]]
// Output: 6
// Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.
// Input: mat = [[3], [4], [8]]
// Output: 4
// Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.
// Constraints:
// 1 ≤ n, m ≤ 400
// 1 ≤ mat[i][j] ≤ 2000
class Solution {

    public int median(int matrix[][]) {
        // code here
        int R = matrix.length;
        int C = matrix[0].length;
        int N = R * C;
        int medianIndex = N / 2;
        int start = 1;
        int end = 2000;
        while (start <= end) {
            int assumedMedian = start + (end - start) / 2;
            //No of Elements lesser that assumedMedian
            // k - No of lesser elements
            int lesserElements = findNoOfSmallerElements(matrix, assumedMedian);
            if (lesserElements <= medianIndex) {
                start = assumedMedian + 1;
            } else {
                end = assumedMedian - 1;
            }
        }
        return start;
    }

    public int findNoOfSmallerElements(int matrix[][], int assumedMedian) {
        int noOfSmallerElements = 0;
        //Traverse row by row
        for (int i = 0; i < matrix.length; i++) {
            //matrix[i] -> 0,1,2
            //int arr = matrix[i]
            //Applying Binary Search on matrix[i]
            int start = 0;
            int end = matrix[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] <= assumedMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            noOfSmallerElements += start;
        }
        return noOfSmallerElements;
    }
}
