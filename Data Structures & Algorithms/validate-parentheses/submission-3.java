class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            } else if (curChar == ')') {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (curChar == '}') {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != '{') {
                    return false;
                }
            } else if (curChar == ']') {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
