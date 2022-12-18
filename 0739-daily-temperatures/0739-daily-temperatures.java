class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ng[] = new int[n];
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            ng[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        int res[] = new int[n];
        
        for(int i=0; i<n; i++){
            System.out.print(ng[i] + " ");
            res[i] = ng[i] == -1 ? 0 : ng[i] - i;
        }
        return res;
    }
}