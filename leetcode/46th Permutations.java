// 46. Permutations

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,0,res);
        return res;
    }
    public void backtrack(int[] nums,int index,List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> arr=new ArrayList<>();
            for(int i:nums){
                arr.add(i);
            }
            res.add(arr);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            backtrack(nums,index+1,res);
            swap(nums,i,index);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

// Not Working For this 
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         int n = nums.length;
//         int fact=1;
//         for(int i=nums.length;i>=1;i--){
//             fact=fact*i;
//         }
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> arr = new ArrayList<>();
//         for(int a:arr){
//             arr.add(a);
//         }
//         res.add(arr);
//         int indexFirst = 0;
//         int indexSecond = 1;
//         for(int i=0;i<fact;i++){
//             res.add(new ArrayList<>(arr));
//             if(indexSecond<=n-1){
//                 int temp=arr.get(indexFirst);
//                 arr.set(indexFirst,arr.get(indexSecond));
//                 arr.set(indexSecond,temp);
//                 indexFirst++;
//                 indexSecond++;
//             }
//             if(indexSecond==n){
//                 indexFirst=0;
//                 indexSecond=1;
//             }
//         }
//         return res;
//     }
// }