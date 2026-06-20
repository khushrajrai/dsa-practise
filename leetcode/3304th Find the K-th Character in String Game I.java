// 3304. Find the K-th Character in String Game I

// Alice and Bob are playing a game. Initially, Alice has a string word = "a".

// You are given a positive integer k.

// Now Bob will ask Alice to perform the following operation forever:

// Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
// For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

// Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

 

// Example 1:

// Input: k = 5

// Output: "b"

// Explanation:

// Initially, word = "a". We need to do the operation three times:

// Generated string is "b", word becomes "ab".
// Generated string is "bc", word becomes "abbc".
// Generated string is "bccd", word becomes "abbcbccd".
// Example 2:

// Input: k = 10

// Output: "c"

 

// Constraints:

// 1 <= k <= 500

class Solution {
    public char kthCharacter(int k) {
        int count = solve(k);
        return (char)('a'+count);
    }
    public int solve(int k){
        //base case - position 1 always has 'a'
        if(k==1){
            return 0;
        }
        //find the smallest power of 2>=k
        int len = 1;
        while(len<k){
            len*=2;
        }
        int half = len/2;
        //left half 
        if(k<=half){
            return solve(k);
        }
        //right half
        return 1+solve(k-half);
    }
}