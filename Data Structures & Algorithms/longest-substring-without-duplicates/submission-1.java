class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxWindow = 0;
        while (j < s.length()) {
            char curChar = s.charAt(j);
            while (set.contains(curChar)) {
                set.remove(s.charAt(i++));
            }
            set.add(curChar);
            maxWindow = Math.max(maxWindow, j - i + 1);
            j++;
        }
        return maxWindow;
    }
}

/*

Approach 1: O(n) time, O(n) space
Keep sliding window
Both pointers start from the first element
Keep track of the characters in the window using a hashset
Move the right pointer
If the character is already in the set, move the left pointer and remove chars from the set until there is space for the right pointer character
Keep track of the max size of the window

*/