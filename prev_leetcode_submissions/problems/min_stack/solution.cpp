class MinStack {
public:
    stack<long long> st;
    long long min;
    MinStack() {
        min = 0;
    }
    
    void push(int value) {
        long long val = (long long) value;
        if(st.empty()){
            min = val;
            st.push(val);
        }else if(val <= min){
            st.push(2*val - min);
            min = val;
        }else{
            st.push(val);
        }
    }
    
    void pop() {
        if(st.empty()) return;
        long long top = st.top();
        st.pop();
        if(top <= min){
            min = 2*min - top; 
        }
    }
    
    int top() {
        if(st.empty()) return -1;
        return st.top() <= min ? min : st.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */