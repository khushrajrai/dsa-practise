// 287. Find the Duplicate Number

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and using only constant extra space.
// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:
// Input: nums = [3,3,3,3,3]
// Output: 3
// Constraints:
// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear only once except for precisely one integer which appears two or more times.
// Cyclic Sort (Fixed Range) - But not optimal as here we modify the array , but in question we have to not modify the array
class Solution {

    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int expectedIndex = nums[i] - 1;
            if (nums[expectedIndex] == nums[i]) {
                i++;
            } else {
                swap(nums, expectedIndex, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] - 1 != j) {
                return nums[j];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

// Brute Force (But only pass 56/59 testcase as it is of O(N2)) here we need O(N)
// class Solution {
//     public int findDuplicate(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j]){
//                     return nums[i];
//                 }
//             }
//         }
//         return -1;
//     }
// }
