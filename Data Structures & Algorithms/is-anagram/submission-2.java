class Solution {
    public boolean isAnagram(String s, String t) {
        // // Approach 1:
        // char[] sChars = s.toCharArray();
        // Arrays.sort(sChars);
        // s = new String(sChars);

        // char[] tChars = t.toCharArray();
        // Arrays.sort(tChars);
        // t = new String(tChars);

        // if (s.length() != t.length()) {
        //     return false;
        // }

        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) != t.charAt(i)) {
        //         return false;
        //     }
        // }
        // return true;

        // Approach 2:
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (sFreq.containsKey(curChar)) {
                sFreq.replace(curChar, sFreq.get(curChar) + 1);
            } else {
                sFreq.put(curChar, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curChar = t.charAt(i);
            if (tFreq.containsKey(curChar)) {
                tFreq.replace(curChar, tFreq.get(curChar) + 1);
            } else {
                tFreq.put(curChar, 1);
            }
        }

        for (char c : sFreq.keySet()) {
            if (!tFreq.containsKey(c)) {
                return false;
            }
            int sf = sFreq.get(c);
            int tf = tFreq.get(c);
            if (sf != tf) {
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