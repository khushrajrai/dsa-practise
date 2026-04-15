// 204. Count Primes

// Given an integer n, return the number of prime numbers that are strictly less than n.
// Example 1:
// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// Example 2:
// Input: n = 0
// Output: 0
// Example 3:
// Input: n = 1
// Output: 0
// Constraints:
// 0 <= n <= 5 * 106
class Solution {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] notPrime = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }

        return count;
    }
}

// Below can be answer but not here as have to follow the time complexity (here 20/66 testcases passed)
// class Solution {
//     public int countPrimes(int n) {
//         if (n<=2) return 0;
//         int count = 0;
//         for(int i=2;i<n;i++){
//             boolean isPrime = true;
//             for(int j=2;j*j<=i;j++){
//                 if(i%j==0){
//                     isPrime = false;
//                     break;
//                 }
//             }
//             if(isPrime){
//                 count++;
//             }
//         }
//         return count;
//     }
// }
