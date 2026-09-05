class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int j = 1;
        while (j < prices.length) {
            int diff = prices[j] - prices[i];
            if (diff < 0) {
                i = j;
            }
            maxProfit = Math.max(maxProfit, diff);
            j++;
        }
        return maxProfit;
    }
}

/*

Approach 1:
Use Sliding Window
Keep two pointers, start from the start
Move the right pointer, record difference between right and left
If it's negative, move left pointer to the right
Otherwise, keep track of the max difference
Output max difference

*/
