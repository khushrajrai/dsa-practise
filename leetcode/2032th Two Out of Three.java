// 2032. Two Out of Three

// Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.
 

// Example 1:

// Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
// Output: [3,2]
// Explanation: The values that are present in at least two arrays are:
// - 3, in all three arrays.
// - 2, in nums1 and nums2.
// Example 2:

// Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
// Output: [2,3,1]
// Explanation: The values that are present in at least two arrays are:
// - 2, in nums2 and nums3.
// - 3, in nums1 and nums2.
// - 1, in nums1 and nums3.
// Example 3:

// Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
// Output: []
// Explanation: No value is present in at least two arrays.
 

// Constraints:

// 1 <= nums1.length, nums2.length, nums3.length <= 100
// 1 <= nums1[i], nums2[j], nums3[k] <= 100

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        // make each array valuee unique 
        // make a frequency map using hashmap adding all arrays occuring
        // return the elements as new array having frequency 2 or more than 2
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for(int val:nums1) set1.add(val);
        for(int val:nums2) set2.add(val);
        for(int val:nums3) set3.add(val);

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int element: set1){
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);
        }    
        for(int element: set2){
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);
        }    
        for(int element: set3){
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int element : freqMap.keySet()){
            if(freqMap.get(element)>1){
                res.add(element);
            }
        }
        
        return res;
    }
}