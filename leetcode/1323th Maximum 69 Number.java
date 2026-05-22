// 1323. Maximum 69 Number

// YYou are given a positive integer num consisting only of digits 6 and 9.

// Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

// Example 1:

// Input: num = 9669
// Output: 9969
// Explanation: 
// Changing the first digit results in 6669.
// Changing the second digit results in 9969.
// Changing the third digit results in 9699.
// Changing the fourth digit results in 9666.
// The maximum number is 9969.
// Example 2:

// Input: num = 9996
// Output: 9999
// Explanation: Changing the last digit 6 to 9 results in the maximum number.
// Example 3:

// Input: num = 9999
// Output: 9999
// Explanation: It is better not to apply any change.
 

// Constraints:

// 1 <= num <= 104
// num consists of only 6 and 9 digits.

class Solution {
    public void reverse(int arr[]){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int tempVar = arr[left];
            arr[left] = arr[right];
            arr[right] = tempVar;
            left++;
            right--;
        }
    }
    public int maximum69Number (int num) {
        // intuition - change very first occurene of 6 to 9 and return new number
        int temp=num;
        int size = String.valueOf(num).length();
        int[] arr = new int[size];
        int index = 0;
        while(temp>0){
            int digit = temp%10;
            arr[index] = digit;
            index++;
            temp/=10;
        }
        reverse(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==6){
                arr[i]=9;
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int val : arr){
            ans.append(val);
        }

        return Integer.parseInt(new String(ans));
    }
}