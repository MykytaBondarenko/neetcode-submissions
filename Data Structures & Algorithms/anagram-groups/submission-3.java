class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // // Approach 2 (Brute force w/ extra space):
        // String[] sorted = new String[strs.length];
        // for (int i = 0; i < strs.length; i++) {
        //     char[] chars = strs[i].toCharArray();
        //     Arrays.sort(chars);
        //     sorted[i] = new String(chars);
        // }

        // List<List<String>> result = new ArrayList<>();
        // for (int i = 0; i < strs.length; i++) {
        //     if (sorted[i] == "*") {
        //         continue;
        //     }
        //     List<String> temp = new ArrayList<>();
        //     temp.add(strs[i]);
        //     for (int j = i + 1; j < strs.length; j++) {
        //         if (sorted[i].equals(sorted[j])) {
        //             temp.add(strs[j]);
        //             sorted[j] = "*";
        //         }
        //     }
        //     sorted[i] = "*";
        //     result.add(temp);
        // }
        // return result;

        // Approach 3 (sort + hashmap):
        HashMap<String, Integer> map = new HashMap<>(); // word -> group index
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            // Sort word
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) { // Add to relevant group
                List<String> temp = list.get(map.get(sorted));
                temp.add(strs[i]);
            } else { // Create a new one
                map.put(sorted, list.size());
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                list.add(temp);
            }
        }
        return list;
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
Time: O(n^2 + n^2logn)
Space: O(n)

Approach 3: Sort words, store groups in a HashMap
Time: O(n^2logn)
Space: O(n)

*/