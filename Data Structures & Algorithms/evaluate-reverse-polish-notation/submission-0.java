class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i1, i2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    i2 = stack.pop();
                    i1 = stack.pop();
                    stack.push(i1 + i2);
                    break;
                case "-":
                    i2 = stack.pop();
                    i1 = stack.pop();
                    stack.push(i1 - i2);
                    break;
                case "*":
                    i2 = stack.pop();
                    i1 = stack.pop();
                    stack.push(i1 * i2);
                    break;
                case "/":
                    i2 = stack.pop();
                    i1 = stack.pop();
                    stack.push(i1 / i2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
