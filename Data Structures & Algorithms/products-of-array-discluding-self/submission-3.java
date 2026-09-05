class Solution {
    public int[] productExceptSelf(int[] nums) {
        // // Approach 1
        // int totalProduct = 1;
        // int countZeros = 0;
        // int zeroIndex = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         countZeros++;
        //         zeroIndex = i;
        //     } else {
        //         totalProduct *= nums[i];
        //     }
        // }
        
        // int[] output = new int[nums.length];
        // if (countZeros >= 2) {
        //     return output;
        // }

        // if (countZeros == 1) {
        //     output[zeroIndex] = totalProduct;
        //     return output;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     output[i] = totalProduct / nums[i];
        // }
        
        // return output;

        // // Approach 2

        // int[] prefixProduct = new int[nums.length];
        // int[] suffixProduct = new int[nums.length];

        // prefixProduct[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        // }

        // suffixProduct[nums.length - 1] = 1;
        // for (int i = nums.length - 2; i >= 0; i--) {
        //     suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        // }

        // int[] output = new int[nums.length];
        // for (int i = 0; i < output.length; i++) {
        //     output[i] = prefixProduct[i] * suffixProduct[i];
        // }
        // return output;

        // Approach 3
        
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            output[i] = output[i] * suffix;
        }
        return output;
    }
}  

/*

Approach 1: O(n) time, O(1) space (not great)
1. Multiply all of the elements in nums
2. Divide the total product by each element in nums and add the result to the output

Approach 2: O(n) time, O(n) space
1. Create an array of all the prefix products
2. Create an array of all the suffix products
3. Go through all the elements and multiply the prefix and the suffix

Approach 3: O(n) time, O(1) space
Expands on Approach 2
Instead of auxillary arrays for prefix and suffix products, store the prefixes in the output array and then iterate again, calculating the prefix on the go

*/