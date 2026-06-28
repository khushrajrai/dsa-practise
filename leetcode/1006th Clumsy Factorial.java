// 1006. Clumsy Factorial

// The factorial of a positive integer n is the product of all positive integers less than or equal to n.

// For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
// We make a clumsy factorial using the integers in decreasing order by swapping out the multiply operations for a fixed rotation of operations with multiply '*', divide '/', add '+', and subtract '-' in this order.

// For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
// However, these operations are still applied using the usual order of operations of arithmetic. We do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.

// Additionally, the division that we use is floor division such that 10 * 9 / 8 = 90 / 8 = 11.

// Given an integer n, return the clumsy factorial of n.

 

// Example 1:

// Input: n = 4
// Output: 7
// Explanation: 7 = 4 * 3 / 2 + 1
// Example 2:

// Input: n = 10
// Output: 12
// Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 

// Constraints:

// 1 <= n <= 104

//O(1) Solution
class Solution {
    public int clumsy(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 6;
        int ans=n*(n-1)/(n-2)+(n-3);
        n-=4;
        while(n>=4){
            ans-=n*(n-1)/(n-2);
            ans+=(n-3);
            n-=4;
        }
        if(n==3) ans-=6;
        else if(n==2) ans-=2;
        else if(n==1) ans-=1;
        return ans;
    }
}

//Using Stack Solution 
// class Solution{
//     public int clumsy(int n){
//         Stack<Integer> st = new Stack<>();
//         st.push(n);
//         int op=0;
//         for(int i=n-1;i>=1;i--){
//             if(op==0){
//                 st.push(st.pop()*i);
//             }
//             else if(op==1){
//                 st.push(st.pop()/i);
//             }
//             else if(op==2){
//                 st.push(i);
//             }
//             else{
//                 st.push(-i);
//             }
//             op=(op+1)%4;
//         }
//         int ans=0;
//         while(!st.isEmpty()){
//             ans+=st.pop();
//         }
//         return ans;
//     }
// }

//Pattern Based Soution
// class Solution {
//     public int clumsy(int n) {
//         if (n == 1) return 1;
//         if (n == 2) return 2;
//         if (n == 3) return 6;
//         if (n == 4) return 7;

//         switch (n % 4) {
//             case 0: return n + 1;
//             case 1: return n + 2;
//             case 2: return n + 2;
//             default: return n - 1;
//         }
//     }
// }


// Here Bodmass Needed so for that here more preferred Stack Using

// class Solution {
//     public int clumsy(int n) {
//         int ans=n;
//         int index=1;
//         int i=n-1;
//         while(i>=1){
//             if(index%4==1){
//                 ans*=i;
//             }
//             if(index%4==2){
//                 ans/=i;
//             }
//             if(index%4==3){
//                 ans+=i;
//             }
//             if(index%4==0){
//                 ans-=i;
//             }
//             index++;
//             i--;
//         }
//         return ans;
//     }
// }
