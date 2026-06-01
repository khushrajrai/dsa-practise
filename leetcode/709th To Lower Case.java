// 709. To Lower Case

// Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
// Example 1:
// Input: s = "Hello"
// Output: "hello"
// Example 2:
// Input: s = "here"
// Output: "here"
// Example 3:
// Input: s = "LOVELY"
// Output: "lovely"
// Constraints:
// 1 <= s.length <= 100
// s consists of printable ASCII characters.
class Solution {

    public String toLowerCase(String s) {
        char arr[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // arr[i]>='65' && arr[i]<=90)
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] + 32);
            }
        }
        return new String(arr);
    }
}
//     public String toLowerCase(String s) {
//         StringBuilder sb = new StringBuilder();
//         for(char ch : s.toCharArray()){
//             if(Character.isUpperCase(ch)){
//                 sb.append(Character.toLowerCase(ch));
//             }
//             else{
//                 sb.append(ch);
//             }          
//         }
//         return sb.toString();
//     }
// }
