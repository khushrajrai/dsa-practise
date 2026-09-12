// 557. Reverse Words in a String III

// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:
// Input: s = "Mr Ding"
// Output: "rM gniD"
// Constraints:
// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.
class Solution {

    public String reverseWords(String s) {
        char arr[] = s.toCharArray();
        int len = arr.length;
        int startPointer = 0;
        for (int endPointer = 0; endPointer <= len; endPointer++) {
            //word will end at space or at end of String
            if (endPointer == len || arr[endPointer] == ' ') {
                reverse(arr, startPointer, endPointer - 1);
                startPointer = endPointer + 1;
            }
        }
        return new String(arr); // <-- Character array to String
    }

    public static void reverse(char[] arr, int startPointer, int endPointer) {
        while (startPointer < endPointer) {
            char temp = arr[startPointer];
            arr[startPointer] = arr[endPointer];
            arr[endPointer] = temp;
            startPointer++;
            endPointer--;
        }
    }
}
