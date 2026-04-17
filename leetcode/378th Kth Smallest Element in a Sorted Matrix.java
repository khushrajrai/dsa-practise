// 378. Kth Smallest Element in a Sorted Matrix

// Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
// You must find a solution with a memory complexity better than O(n2).
// Example 1:
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13
// Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
// Example 2:
// Input: matrix = [[-5]], k = 1
// Output: -5
// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= 109
// All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
// 1 <= k <= n2
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;
        int N = R * C;
        int requiredSmallerElements = k - 1;
        int start = matrix[0][0];
        int end = matrix[R - 1][C - 1];
        while (start <= end) {
            int assumedKthElement = start + (end - start) / 2;
            //No of Elements lesser that assumedMedian
            // k - No of lesser elements
            int smallerElements = findSmallerElements(matrix, assumedKthElement);
            if (smallerElements <= requiredSmallerElements) {
                start = assumedKthElement + 1;
            } else {
                end = assumedKthElement - 1;
            }
        }
        return start;
    }

    public int findSmallerElements(int[][] matrix, int assumedKthElement) {
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
                if (matrix[i][mid] <= assumedKthElement) {
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
