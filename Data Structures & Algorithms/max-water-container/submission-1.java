class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxVol = 0;
        while (i < j) {
            int curVol = Math.min(heights[i], heights[j]) * (j - i);
            maxVol = Math.max(curVol, maxVol);

            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxVol;
    }
}
