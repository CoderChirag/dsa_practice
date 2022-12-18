class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
    
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            switch(tokens[i]){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    st.push((int)(1D/st.pop() * st.pop()));
                    break;
                default:
                    st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}