// 3120. Count the Number of Special Characters I

// You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
// Return the number of special letters in word.
// Example 1:
// Input: word = "aaAbcBC"
// Output: 3
// Explanation:
// The special characters in word are 'a', 'b', and 'c'.
// Example 2:
// Input: word = "abc"
// Output: 0
// Explanation:
// No character in word appears in uppercase.
// Example 3:
// Input: word = "abBCab"
// Output: 1
// Explanation:
// The only special character in word is 'b'.
// Constraints:
// 1 <= word.length <= 50
// word consists of only lowercase and uppercase English letters.
class Solution {

    public int numberOfSpecialChars(String word) {
        HashSet<Character> a = new HashSet<>();
        HashSet<Character> b = new HashSet<>();
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                a.add(ch);
            } else {
                b.add(Character.toLowerCase(ch));
            }
        }
        for (char ch : a) {
            if (b.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}
