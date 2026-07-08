class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        s = new String(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        t = new String(tChars);

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

/*

Approach 1: Sort both strings and compare character - by character
Time: O(nlogn)
Space: O(1)

Approach 2: Count each character's frequency in each string and compare
Time: O(n)
Space: O(n)

*/