class MinStack {
    List<Integer> list;
    int i;
    Stack<Integer> curMin;

    public MinStack() {
        list = new ArrayList<>();
        i = -1;
        curMin = new Stack<>();
    }
    
    public void push(int val) {
        i++;
        list.add(val);
        if (curMin.empty()) {
            curMin.push(val);
        } else {
            curMin.push(Math.min(val, curMin.peek()));
        }
    }
    
    public void pop() {
        curMin.pop();
        list.remove(i--);
    }
    
    public int top() {
        return list.get(i);
    }
    
    public int getMin() {
        return curMin.peek();
    }
}

/*

Approach:
Push, pop, peek are obvious
getMin() in O(1) is tricky
The idea is to use an auxillary stack
This stack will store current minimal value at this element in our regular stack
We update them together with the values in the regular stack

*/
