class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Approach 2 (Brute force w/ extra space):
        String[] sorted = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted[i] = new String(chars);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (sorted[i] == "*") {
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (sorted[i].equals(sorted[j])) {
                    temp.add(strs[j]);
                    sorted[j] = "*";
                }
            }
            sorted[i] = "*";
            result.add(temp);
        }
        return result;
    }
}

/*

Approach 1: Brute force
Start with the first word. Check for all the anagrams and put them together.
Do this for all remaining strings.
Time: O(n^2logn)
Space: O(1)

Approach 2: Brute force w/ extra space
Sort all the words and put them into an array.
Group the words together
Time: O(n^2 + nlogn)
Space: O(n)

*/