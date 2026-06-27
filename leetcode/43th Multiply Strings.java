// 43. Multiply Strings

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

// Example 1:

// Input: num1 = "2", num2 = "3"
// Output: "6"
// Example 2:

// Input: num1 = "123", num2 = "456"
// Output: "56088"
 

// Constraints:

// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.

class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int ans[] = new int[num1.length()+num2.length()-1];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                ans[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for(int i=ans.length-1;i>0;i--){
            ans[i-1]+=ans[i]/10;
            ans[i]%=10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i);
        }
        return sb.toString();
    }
}


// Not here Working as of Constraints
// class Solution {
//     public String multiply(String num1, String num2) {
//         int str1 = Integer.parseInt(num1);
//         int str2 = Integer.parseInt(num2);
//         int res = str1*str2;
//         String result = Integer.toString(res);
//         return result;
//     }
// }