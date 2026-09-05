class Solution {
    public boolean isAlphaNum(char c) {
        if ((int)c >= (int)'a' && (int)c <= (int)'z') return true;
        if ((int)c >= (int)'0' && (int)c <= (int)'9') return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (i < j && !isAlphaNum(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlphaNum(s.charAt(j))) {
                j--;
            }
            if (!(s.charAt(i++) == s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}

/*

Approach 1:
Make the string lowercase
Have a pointer i at the start of the string and j at the end of the string
Move the pointer until we reach an alphanumeric char
Check if char i and char j are equal
If no -> return false
Increment i, decrement j
Repeat, until i reaches j or goes over it
Return true

*/