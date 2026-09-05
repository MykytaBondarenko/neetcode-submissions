class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int target = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}

/*

Approach 1: Brute force O(n^3) time, O(n) space
Check all triplets possible
If valid - check if it already exists and add to the list

Approach 2: O(n^2 logn) = O(n^2) time and O(1) space
Sort the array
Start going through the numbers from the left
Number * -1 is out target at the moment
Use Sorted TwoSum approach to find a valid combination to the right of the Number
! For each first number there might be multiple TwoSums, but be careful of duplicates !
If the next number is a duplicate, skip it (avoids duplicate triplets entirely)


*/