class StockSpanner {
public:
    stack<int> st;
    vector<int> v;
    StockSpanner() {
        
    }
    
    int next(int price) {
        if(v.size() == 0){
            st.push(0);
            v.push_back(price);
            return 1;
        }
        int n = v.size();
        v.push_back(price);
        while(!st.empty() && price >= v[st.top()]) st.pop();
        int res = st.empty() ? n+1 : n - st.top();
        st.push(n);
        return res;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */