// First negative in every window of size k

// Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
// Note: If a window does not contain a negative integer, then return 0 for that window.
// Examples:
// Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
// Output: [-8, 0, -6, -6]
// Explanation:
// Window [-8, 2] First negative integer is -8.
// Window [2, 3] No negative integers, output is 0.
// Window [3, -6] First negative integer is -6.
// Window [-6, 10] First negative integer is -6.
// Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
// Output: [-1, -1, -7, -15, -15, 0] 
// Explanation:
// Window [12, -1, -7] First negative integer is -1.
// Window [-1, -7, 8] First negative integer is -1.
// Window [-7, 8, -15] First negative integer is -7.
// Window [8, -15, 30] First negative integer is -15.
// Window [-15, 30, 16] First negative integer is -15.
// Window [30, 16, 28] No negative integers, output is 0.
// Input: arr[] = [12, 1, 3, 5] , k = 3
// Output: [0, 0] 
// Explanation:
// Window [12, 1, 3] No negative integers, output is 0.
// Window [1, 3, 5] No negative integers, output is 0.
// Constraints:
// 1 <= arr.size() <= 106
// -105 <= arr[i] <= 105
// 1 <= k <= arr.size()
class Solution {

    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int index = 0;
        while (index < k) {
            if (arr[index] < 0) {
                queue.offer(arr[index]);
            }
            index++;
        }
        res.add(queue.isEmpty() ? 0 : queue.peek());
        for (int i = 1; i <= n - k; i++) {
            if (arr[i - 1] < 0) {
                queue.poll();
            }
            if (arr[i + k - 1] < 0) {
                queue.offer(arr[i + k - 1]);
            }
            res.add(queue.isEmpty() ? 0 : queue.peek());
        }
        return res;
    }
}
