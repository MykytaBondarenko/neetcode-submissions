class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // Approach 1 (Brute force):
        // for (int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i != j && complement == nums[j]) {
        //             int[] res = new int[]{i, j};
        //             return res;
        //         }
        //     }
        // }
        // return new int[]{0, 0};

        // Approach 2 (complement HashMap):
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            int complement = target - nums[i];
            map.put(complement, i);
        }
        return new int[]{0, 0};
    }
}

/*

Approach 1: Brute force
For each number, find a number that sums up to target
Time: O(n^2)
Space: O(1)

Approach 2: complement HashMap (complement for me is a number that needs to sum current number to target)
Keep a HashMap, which stores complements of numbers and their indeces.
So we can instantly check if current number is a complement to another number to get to target
HashMap: complement -> index
Time: O(n)
Space: O(n)

*/