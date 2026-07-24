// 215. Kth Largest Element in an Array

// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?
// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
// Constraints:
// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104
//Using Priority Queue
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                //keep minimum on top and poll (remove) when size exceeds k thus at end keep two maximum only
                pq.poll();
            }
        }
        //return second largest in pq (top element is smaller in minHeap thus peek)
        return pq.peek();
    }
}
//Using Sorting method - Brute Force

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         return nums[n-k];
//     }
// }
