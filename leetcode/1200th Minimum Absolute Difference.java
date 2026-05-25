// 1200. Minimum Absolute Difference

// Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
// Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
// a, b are from arr
// a < b
// b - a equals to the minimum absolute difference of any two elements in arr
// Example 1:
// Input: arr = [4,2,1,3]
// Output: [[1,2],[2,3],[3,4]]
// Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
// Example 2:
// Input: arr = [1,3,6,10,15]
// Output: [[1,3]]
// Example 3:
// Input: arr = [3,8,-10,23,19,-4,-14,27]
// Output: [[-14,-10],[19,23],[23,27]]
// Constraints:
// 2 <= arr.length <= 105
// -106 <= arr[i] <= 106

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Math.abs(arr[0] - arr[1]);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int currentDiff = Math.abs(arr[i] - arr[i+1]) ;
            if (currentDiff < minDiff) {
                result.clear();
                minDiff = currentDiff;
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[i+1]);
                result.add(res);
            } else if (currentDiff == minDiff) {
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[i+1]);
                result.add(res);
            }
        }
        return result;

    }
}
