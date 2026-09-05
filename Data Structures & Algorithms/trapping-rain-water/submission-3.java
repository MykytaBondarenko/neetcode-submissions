class Solution {
    public int trap(int[] height) {
        // // Approach 1
        // int vol = 0;
        // int i = 0;
        // int j = height.length - 1;
        // int curHeight = 0;
        // while (i < j) {
        //     while (i < j && height[i] <= curHeight) {
        //         i++;
        //     }
        //     while (i < j && height[j] <= curHeight) {
        //         j--;
        //     }
        //     for (int k = i + 1; k < j; k++) {
        //         if (height[k] <= curHeight) {
        //             vol++;
        //         }
        //     }
        //     curHeight++;
        // }
        // return vol;

        // Approach 2
        int i = 0;
        int j = height.length - 1;
        int totalVolume = 0;
        int leftH = height[i];
        int rightH = height[j];
        while (i < j) {
            if (leftH < rightH) {
                i++;
                leftH = Math.max(leftH, height[i]);
                totalVolume += leftH - height[i];
            } else {
                j--;
                rightH = Math.max(rightH, height[j]);
                totalVolume += rightH - height[j];
            }
        }
        return totalVolume;
    }
}

/*

Approach 1: (TLE)
Intuitively, this is very similar to a water tank problem
However, It's easier to find all the volume of water if we go from bottom - up

Approach 2: O(n) time, O(1) space
We can look at the bars from each end and find the bars where we can "start 
collecting water" (following bar would be lower)
Starting with the shorter bar, go to the following bars and count diff and volume,
until we reach the higher bar
Update the shorter bar and continue until the pointers meet

*/