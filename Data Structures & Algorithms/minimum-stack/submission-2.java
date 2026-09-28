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
        } else if (curMin.peek() >= val) {
            curMin.push(val);
        }
    }
    
    public void pop() {
        if (curMin.peek().intValue() == list.get(i).intValue()) {
            curMin.pop();
        }
        list.remove(i--);
    }
    
    public int top() {
        return list.get(i);
    }
    
    public int getMin() {
        return curMin.peek();
    }
}
