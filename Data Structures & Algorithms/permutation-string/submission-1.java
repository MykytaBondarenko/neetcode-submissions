class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.putIfAbsent(s1.charAt(i), 0);
            map1.replace(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ci = s2.charAt(i);
            map2.putIfAbsent(ci, 0);
            map2.replace(ci, map2.get(ci) + 1);
            if (i >= s1.length()) {
                char cj = s2.charAt(i - s1.length());
                map2.replace(cj, map2.get(cj) - 1);
                if (map2.get(cj) == 0) {
                    map2.remove(cj);
                }
            }
            if (map1.equals(map2)) {
                return true;
            }
        }

        return false;
    }
}

/*

Approach 1: HashMaps
Create a HashMap of character -> frequency from s1
Keep a window of size s1.length() and slide it through s2
Keep the frequencies of characters in the window in another HashMap
Compare window frequencies to s1 frequencies
If equals, return true
If went through the entire s2, return false

*/
