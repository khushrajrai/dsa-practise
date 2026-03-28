// 7. Reverse Integer

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
 

// Constraints:

// -231 <= x <= 231 - 1


public class Solution {

    public int reverse(int x) {
        boolean isNeg = false;
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            isNeg = true;
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            x = -1 * x;
        }
        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + digit;
            x = x / 10;
        }
        if (isNeg == true) {
            res = -1 * res;
        }
        return res;
    }
}
{
    
}
