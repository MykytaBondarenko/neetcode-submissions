class Solution {
    public int longestConsecutive(int[] nums) {
        // // Approach 1
        // if (nums.length == 0) {
        //     return 0;
        // }

        // int min = nums[0];
        // int max = nums[0];
        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (min > nums[i]) {
        //         min = nums[i];
        //     }
        //     if (max < nums[i]) {
        //         max = nums[i];
        //     }
        //     set.add(nums[i]);
        // }

        // int maxSeq = 0;
        // int curSeq = 0;
        // for (int i = min; i <= max; i++) {
        //     if (set.contains(i)) {
        //         curSeq++;
        //     } else {
        //         if (maxSeq < curSeq) {
        //             maxSeq = curSeq;
        //         }
        //         curSeq = 0;
        //     }
        // }
        // if (maxSeq < curSeq) {
        //     maxSeq = curSeq;
        // }
        // return maxSeq;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSequence = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curSequence = 1;
                while (set.contains(num + curSequence)) {
                    curSequence++;
                }
                maxSequence = Math.max(maxSequence, curSequence);
            }
        }
        return maxSequence;
    }
}

/*

Approach 1: O(n + m) time, O(n) space (time limit exceded)
Go through all of the elements in nums and:
1. Find min and max elements
2. Put all the elements in the HashSet
Then, start going from min to max
Check if num is in the hashset
Track the sequences
If the sequence stops, update maxsequence and reset

*/
