// 268. Missing Number

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation:
// n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
// Example 2:
// Input: nums = [0,1]
// Output: 2
// Explanation:
// n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
// Example 3:
// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation:
// n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
// Constraints:
// n == nums.length
// 1 <= n <= 104
// 0 <= nums[i] <= n
// All the numbers of nums are unique.
// Using XOR & Bit Manipulation
class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorNum = 0;
        int xorEle = 0;
        for (int i = 0; i < n; i++) {
            xorNum = xorNum ^ i;
            xorEle = xorEle ^ nums[i];
        }
        xorNum = xorNum ^ n;
        return xorNum ^ xorEle;
    }
}

// Using Cyclic Sort (Fixed Range)
// class Solution {
//     public int missingNumber(int[] nums) {
//         int i=0;
//         int n = nums.length;
//         while(i<n){
//             int expectedIndex = nums[i];
//             if(expectedIndex>=n || nums[expectedIndex] == nums[i]){
//                 i++;
//             }
//             else{
//                 swap(nums,expectedIndex,i);
//             }
//         }
//         for(int j=0;j<n;j++){
//             if(nums[j]!=j){
//                 return j;
//             }
//         }
//         return n;
//     }
//     public void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }
