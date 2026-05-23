// Max Sum Subarray of size K

// Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
// Note: A subarray is a contiguous part of any given array.
// Examples:
// Input: arr[] = [100, 200, 300, 400], k = 2
// Output: 700
// Explanation: arr2 + arr3 = 700, which is maximum.
// Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
// Output: 39
// Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
// Input: arr[] = [100, 200, 300, 400], k = 1
// Output: 400
// Explanation: arr3 = 400, which is maximum.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 106
// 1 ≤ k ≤ arr.size()
class Solution {

    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int index = 0;
        int maxSum = 0;
        int sum = 0;
        while (index < n && index < k) {
            sum += arr[index];
            index++;
        }
        maxSum = sum;
        for (int i = 1; i <= n - k; i++) {
            int prevEle = arr[i - 1];
            int nextEle = arr[i + k - 1];
            sum = sum - prevEle + nextEle;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
