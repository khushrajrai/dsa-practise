// 3. Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest substring without duplicate characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while (windowEnd < n) {
            char ch = s.charAt(windowEnd);
            if (map.containsKey(ch) && map.get(ch) >= windowStart) {
                windowStart = map.get(ch) + 1;
            }
            map.put(ch, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}
