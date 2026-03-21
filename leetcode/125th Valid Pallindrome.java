class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder reversed = new StringBuilder() ;

        for (int i = s.length()-1; i>=0; i--){
            reversed.append(s.charAt(i));
        }

        if (s.equals(reversed.toString())){
            return true;
        }
        else{
            return false;
        }

    }
}