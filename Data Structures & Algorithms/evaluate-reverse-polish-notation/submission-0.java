class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for( String s : tokens){
            if (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/")) {

                int a = stk.pop();
                int b = stk.pop();

                if (s.equals("+")) {
                    stk.push(b + a);
                }
                else if (s.equals("-")) {
                    stk.push(b - a);
                }
                else if (s.equals("*")) {
                    stk.push(b * a);
                }
                else {
                    stk.push(b / a);
                }

            } else {

                stk.push(Integer.parseInt(s));

            }            
        }
        return stk.peek();
    }
}
