class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> elToFreq = new HashMap<>();
        HashMap<Integer, List<Integer>> freqToEl = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            if (elToFreq.containsKey(nums[i])) {
                elToFreq.replace(nums[i], elToFreq.get(nums[i]) + 1);
            } else {
                elToFreq.put(nums[i], 1);
            }
        }

        for (int el : elToFreq.keySet()) {
            int freq = elToFreq.get(el);
            if (freqToEl.containsKey(freq)) {
                List<Integer> els = freqToEl.get(freq);
                els.add(el);
            } else {
                List<Integer> els = new ArrayList<>();
                els.add(el);
                freqToEl.put(freq, els);
            }
        }

        for (int i = nums.length; i > 0; i--) {
            if (freqToEl.containsKey(i)) {
                List<Integer> els = freqToEl.get(i);
                while (els.size() > 0) {
                    result[--k] = els.remove(els.size() - 1);
                    if (k <= 0) {
                        break;
                    }
                }
            }
            if (k <= 0) {
                break;
            }
        }

        return result;
    }
}

/*

Approach 1:
Count frequencies of each element with a hashmap
HashMap: element -> frequency
Create an inverse hashmap
HashMap: frequency -> set of elements
Check frequencies from n to 1 and add elements to the list until there are k of them
Time: O(n)
Space: O(n)

*/