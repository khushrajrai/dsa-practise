// 3663. Find The Least Frequent Digit

// Given an integer n, find the digit that occurs least frequently in its decimal representation. If multiple digits have the same frequency, choose the smallest digit.
// Return the chosen digit as an integer.
// The frequency of a digit x is the number of times it appears in the decimal representation of n.
// Example 1:
// Input: n = 1553322
// Output: 1
// Explanation:
// The least frequent digit in n is 1, which appears only once. All other digits appear twice.
// Example 2:
// Input: n = 723344511
// Output: 2
// Explanation:
// The least frequent digits in n are 7, 2, and 5; each appears only once.
// Constraints:
// 1 <= n <= 231​​​​​​​ - 1
class Solution {

    public int getLeastFrequentDigit(int n) {
        int freq[] = new int[10];
        int temp = n;
        while (temp > 0) {
            freq[temp % 10]++;
            temp = temp / 10;
        }
        int resultDigit = -1;
        int count = Integer.MAX_VALUE;
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0) {
                if (freq[d] < count) {
                    count = freq[d];
                    resultDigit = d;
                } else if (freq[d] == count) {
                    resultDigit = Math.min(resultDigit, d);
                }
            }
        }
        return resultDigit;
    }
}

// Using HashMap 
// class Solution {
//     public int getLeastFrequentDigit(int n) {
//         HashMap<Integer,Integer> freqMap = new HashMap<>();
//         while(n>0){
//             int digit = n%10;
//             freqMap.put(digit,freqMap.getOrDefault(digit,0)+1);
//             n = n/10;
//         }
//         int minFreq = Integer.MAX_VALUE;
//         int resultDigit = Integer.MAX_VALUE;
//         for(int digit : freqMap.keySet()){
//             int freq = freqMap.get(digit);
//             if(freq<minFreq){
//                 minFreq = freq;
//                 resultDigit = digit;
//             }
//             else if(freq==minFreq){
//                 resultDigit = Math.min(resultDigit,digit);
//             }
//         }
//         return resultDigit;
//     }
// }
