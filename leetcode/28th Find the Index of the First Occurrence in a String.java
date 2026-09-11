// 28. Find the Index of the First Occurrence in a String

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
// Example 1:
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
// Constraints:
// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.
//Using Rabin Karp (Rolling Hash Algorithm)
class Solution {

    public int strStr(String text, String pat) {
        int n = text.length();
        int m = pat.length();
        if (m > n) {
            return -1;
        }
        int base = 256;
        int mod = 101;
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }
        //initial window hash
        int wh = 0;
        int ph = 0;
        for (int i = 0; i < m; i++) {
            wh = (base * wh + text.charAt(i)) % mod;
            ph = (base * ph + pat.charAt(i)) % mod;
        }
        //compare
        // if(wh==ph){
        //     int j=0;
        //     while(j<m){
        //         if(text.charAt(j)!=pat.charAt(j)){
        //             break;
        //         }
        //         j++;
        //     }
        //     if(j==m) return 0;
        // }
        //Next Window
        for (int i = 0; i <= n - m; i++) {
            //compare
            if (wh == ph) {
                int j = 0;
                while (j < m) {
                    if (text.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == m) {
                    return i;
                }
            }
            //rolling hash
            if (i < n - m) {
                wh = (wh - text.charAt(i) * h) % mod;
                wh = (wh * base + text.charAt(i + m)) % mod;
                if (wh < 0) {
                    wh += mod;
                }
            }

        }
        return -1;
    }
}

// //Using KMP (Knuth-Morris Pratt Algorithm)
// class Solution{
//     public int[] buildLPS(char pattern[]){
//         int len=0;
//         int i=1;
//         int n=pattern.length;
//         //LPS - Longest Prefix which is also a suffix
//         int lps[] = new int[n];
//         while(i<n){
//             if(pattern[len]==pattern[i]){
//                 len++;
//                 lps[i]=len;
//                 i++;
//             }else{
//                 if(len==0) i++;
//                 else len=lps[len-1];
//             }
//         }
//         return lps;
//     }
//     public int strStr(String text,String pat){
//         //KMP
//         char pattern[]=pat.toCharArray();
//         int lps[]=buildLPS(pattern);
//         int i=0;
//         int j=0;
//         int n=text.length();
//         int m=pat.length();
//         while(i<n){
//             if(pat.charAt(j)==text.charAt(i)){
//                 i++;
//                 j++;
//                 if(j==m){
//                     return (i-m);
//                 }
//             }else{
//                 if(j==0) i++;
//                 else j=lps[j-1];
//             }
//         }
//         return -1;
//     }
// }
// class Solution {
//     public int strStr(String haystack, String needle) {
//         if (needle.length()==0) return 0;
//         for (int i=0;i<=haystack.length()-needle.length();i++){
//             int j=0;
//             while (j<needle.length() && haystack.charAt(i+j)==needle.charAt(j) ){
//                 j++;
//             }
//             if (j == needle.length()){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
