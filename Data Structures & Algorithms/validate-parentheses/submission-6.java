class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            } else if (curChar == ')' || curChar == '}' || curChar == ']') {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != map.get(curChar)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
