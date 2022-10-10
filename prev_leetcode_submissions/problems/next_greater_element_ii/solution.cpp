class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& arr) {
        vector<int> res(arr.size(), -1);
        stack<int> st;
        int n = arr.size();
        for(int i=2*n-1; i>=0; i--){
            while(!st.empty() && arr[i%n] >= arr[st.top()]) st.pop();
            res[i%n] = st.empty() ? -1 : arr[st.top()];
            st.push(i%n);
        }
        return res;
    }
};