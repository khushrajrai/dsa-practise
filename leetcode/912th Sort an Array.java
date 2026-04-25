// 912. Sort an Array

// Given an array of integers nums, sort the array in ascending order and return it.

// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of nums are not necessarily unique.
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -5 * 104 <= nums[i] <= 5 * 104

// Using O(nlog(n)) Time complexity
class Solution{
    public int[] sortArray(int[] nums){
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    void mergeSort(int[] nums, int left, int right){
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    void merge(int[] nums,int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];

        for(int p=0;p<temp.length;p++){
            nums[left+p] = temp[p];
        }
    }
}

// Using Built-in funciton - Time Complexity of Built in sorting array - O(nlog(n))

// class Solution {
//     public int[] sortArray(int[] nums) {
//         Arrays.sort(nums);
//         return nums;
//     }
// }

// Basic for loop solution - TC O(N2)
// class Solution{
//     public int[] sortArray(int[] nums){
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]>nums[j]){
//                     int temp = nums[i];
//                     nums[i] = nums[j];
//                     nums[j] = temp;
//                 }
//             }
//         }
//         return nums;
//     }
// }
