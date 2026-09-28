class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> aux = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (aux.empty()) {
                aux.push(i);
                continue;
            }
            if (temperatures[aux.peek()] >= temperatures[i]) {
                aux.push(i);
                continue;
            }
            while (!aux.empty() && temperatures[aux.peek()] < temperatures[i]) {
                res[aux.peek()] = i - aux.pop();
            }
            aux.push(i);
        }
        while (!aux.empty()) {
            res[aux.pop()] = 0;
        }
        return res;
    }
}

/*

Approach:
Have an auxillary array, which will keep the indeces of elements
We are going to add indeces of all elements, if the last element in that stack
is greater or equals to current temperature
Otherwise, we're going to pop elements from this stack and populate the array
on those popped elements with the days difference (cur index - popped index) until
we reach an element that is bigger or equals or the stack is empty
In the end, pop all the remaining elements in the stack and populate the indices
with 0s
Time complexity: O(n)
Space complexity: O(n)

*/