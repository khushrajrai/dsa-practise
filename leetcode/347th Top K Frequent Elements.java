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
//Using MinHeap PQ + HashMap
class Number implements Comparable<Number> {

    int element;
    int freq;

    Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    public int compareTo(Number that) {
        return this.freq - that.freq; //increasing (for min heap)
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        //find all freq of elements
        for (int element : nums) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }
        //insert elements in pq
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int res[] = new int[k];
        int index = 0;
        while (index < k) {
            Number number = pq.poll();
            res[index] = number.element;
            index++;
        }
        return res;
    }
}

// Using HashMap and Sorting
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Step 1 - Frequency Map
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i:nums){
//             map.put(i,map.getOrDefault(i,0)+1);
//         }
//         // Step 2 - Put keys into list
//         List<Integer> list = new ArrayList<>(map.keySet());
//         //Step 3 - Sort by Frequency (Descending)
//         list.sort((a,b)->Integer.compare(map.get(b),map.get(a)));
//         // Step 4 - Take first k elements
//         int[] result = new int[k];
//         for(int i=0;i<k;i++){
//             result[i] = list.get(i);
//         }
//         return result;
//     }
// }
