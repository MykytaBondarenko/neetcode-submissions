class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int countZeros = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
                zeroIndex = i;
            } else {
                totalProduct *= nums[i];
            }
        }
        
        int[] output = new int[nums.length];
        if (countZeros >= 2) {
            return output;
        }

        if (countZeros == 1) {
            output[zeroIndex] = totalProduct;
            return output;
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = totalProduct / nums[i];
        }
        
        return output;
    }
}  

/*

Approach 1: O(n) time, O(1) space
1. Multiply all of the elements in nums
2. Divide the total product by each element in nums and add the result to the output

*/