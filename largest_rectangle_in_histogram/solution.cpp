class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<int> st;
        int res = 0;
        for(int i=0; i<n; i++){
            while(!st.empty() && heights[st.top()] >= heights[i]){
                int x = st.top();
                st.pop();
                int curr = heights[x]*(st.empty() ? i : (i - st.top() - 1));
                res = max(curr, res);
            }
            st.push(i);
        }
        while(!st.empty()){
            int top = st.top();
            st.pop();
            int curr = heights[top]*(st.empty() ? n : (n - st.top() - 1));
            res = max(curr, res);
        }
        return res;
    }
};