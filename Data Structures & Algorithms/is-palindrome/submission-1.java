class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String chars = "qwertyuiopasdfghjklzxcvbnm0123456789";
        s = s.toLowerCase();
        while (i < s.length() && !chars.contains(s.substring(i, i + 1))) {
            i++;
        }
        while (j >= 0 && !chars.contains(s.substring(j, j + 1))) {
            j--;
        }
        while (i < j) {
            System.out.println(i + " " + j);
            if (!(s.charAt(i++) == s.charAt(j--))) {
                return false;
            }
            while (i < s.length() && !chars.contains(s.substring(i, i + 1))) {
                i++;
            }
            while (j >= 0 && !chars.contains(s.substring(j, j + 1))) {
                j--;
            }
        }
        return true;
    }
}

/*

Approach 1:
Have a pointer i at the start of the string and j at the end of the string
Check if char i and char j are equal
If no -> return false
Increment i, decrement j
Repeat, until i reaches j or goes over it
Return true

*/