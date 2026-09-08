// 438. Find All Anagrams in a String

// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

// Constraints:

// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if(m>n){
            return res;
        }
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        //initial window
        for(int i=0;i<m;i++){
            int si=s.charAt(i)-'a';
            int pi=p.charAt(i)-'a';
            sCount[si]++;
            pCount[pi]++;
        }
        if(Arrays.equals(sCount,pCount)){
            res.add(0);
        }
        for(int i=1;i<=n-m;i++){
            int prev=s.charAt(i-1)-'a';
            int next=s.charAt(i+m-1)-'a';
            sCount[prev]--;
            sCount[next]++;
            if(Arrays.equals(sCount,pCount)){
                res.add(i);
            }
        }
        return res;
    }
}