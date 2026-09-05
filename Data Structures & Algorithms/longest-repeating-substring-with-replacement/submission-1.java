class Solution {
    public int maxFreq(int[] freqs) { // O(1)
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freqs[i] > maxFreq) {
                maxFreq = freqs[i];
            }
        }
        return maxFreq;
    }
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int i = 0;
        int j = 0;
        int maxWindow = 0;
        while (j < s.length()) { // we check each element up to 2 times, so O(n)
            freqs[(int)s.charAt(j) - (int)'A']++;
            while ((j - i + 1) - maxFreq(freqs) > k) {
                freqs[(int)s.charAt(i) - (int)'A']--;
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1);
            j++;
        }
        return maxWindow;
    }
}

/*

Approach 1: O(n) time, O(1) space
Keep a sliding window
Keep track of the character frequencies
Identify characters with the highest frequency in the window
Keep windowSize - highestFrequency less than or equal to k
Keep track of max window size

*/
