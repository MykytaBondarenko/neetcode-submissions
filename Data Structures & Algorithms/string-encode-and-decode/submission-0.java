class Solution {

    public String encode(List<String> strs) { // O(n) time, O(m + n) space
        StringBuilder result = new StringBuilder();
        for (String st : strs) { // O(n)
            result.append(st.length()); // O(1)
            result.append("*"); // O(1)
            result.append(st); // O(1)
        }
        return result.toString();
    }

    public List<String> decode(String str) { // O(m + n) time, O(n) space
        List<String> result = new ArrayList<>();
        int stLen = 0;
        int i = 0;
        while (i < str.length()) { // O(m + n)
            if (str.charAt(i) == '*') {
                result.add(str.substring(i + 1, i + 1 + stLen));
                i = i + 1 + stLen;
                stLen = 0;
            } else {
                stLen = stLen * 10 + Integer.parseInt(str.charAt(i) + "");
                i++;
            }
        }
        return result;
    }
}

/*

Approach 1: (failing)
Encode:
1. Find a delimiter (a character that doesn't occur in any of the strings in the list)
2. Concatenate all the strings in the list, putting a delimiter between the strings
3. Put the delimiter at the start of the string

Decode:
1. Identify the delimiter by the first character
2. Split the string by delimiter
3. Put the strings into the list

Approach 2:
Encode:
1. For each string, calculate its length
2. Put the length of the string before it, with some kind of a barrier before the string (in case the string starts with a digit)
3. Add the string to the output

Decode:
1. Get the length from the start of encoded string
2. Get the string out
3. Add it to the list and repeat

*/

/*

5*Hello5*World


*/