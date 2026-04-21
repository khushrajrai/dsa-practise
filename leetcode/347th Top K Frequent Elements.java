// 347. Top K Frequent Elements

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:
// Input: nums = [1], k = 1
// Output: [1]
// Example 3:
// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
// Output: [1,2]
// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// Seen this question in a real interview before?
// 1/6
// Yes
// No
// Using HashMap and Sorting
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1 - Frequency Map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Step 2 - Put keys into list
        List<Integer> list = new ArrayList<>(map.keySet());

        //Step 3 - Sort by Frequency (Descending)
        list.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        // Step 4 - Take first k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
