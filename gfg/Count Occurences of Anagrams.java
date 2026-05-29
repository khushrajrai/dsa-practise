// Count Occurences of Anagrams

// Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
// Example 1:
// Input: txt = "forxxorfxdofr", pat = "for"
// Output: 3
// Explanation: for, orf and ofr appears in the txt, hence answer is 3.
// Example 2:
// Input: txt = "aabaabaa", pat = "aaba"
// Output: 4
// Explanation: aaba is present 4 times in txt.
// Constraints:
// 1 <= |pat| <= |txt| <= 105
// Both strings contain lowercase English letters.
// User function Template for Java
class Solution {

    int search(String pat, String txt) {
        // code here
        int k = pat.length();
        int n = txt.length();
        int patFreq[] = new int[26];
        //calculate pattern frequency
        for (int i = 0; i < k; i++) {
            int index = pat.charAt(i) - 97;
            patFreq[index]++;

        }
        // init window (first window for txt)
        int txtFreq[] = new int[26];
        for (int i = 0; i < k; i++) {
            int index = txt.charAt(i) - 97;
            txtFreq[index]++;
        }
        int count = 0;
        if (Arrays.equals(txtFreq, patFreq)) {
            count += 1;
        }
        //calculate for all windows
        for (int i = 1; i <= n - k; i++) {
            int removeCharIndex = txt.charAt(i - 1) - 97;
            int addCharIndex = txt.charAt(i + k - 1) - 97;
            txtFreq[removeCharIndex]--;
            txtFreq[addCharIndex]++;
            if (Arrays.equals(txtFreq, patFreq)) {
                count += 1;
            }
        }
        return count;
    }
}
