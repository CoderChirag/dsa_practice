class MyStack {
    queue<int> q1;
    queue<int> q2;
public:
    MyStack() {
    }
    
    void push(int x) {
        q2.push(x);
        while(!q1.empty()){
            q2.push(q1.front());
            q1.pop();
        }
        queue<int> q = q1;
        q1 = q2;
        q2 = q;
    }
    
    int pop() {
        if(q1.empty()) return -1;
        int data = q1.front();
        q1.pop();
        return data;
    }
    
    int top() {
        return q1.front();
    }
    
    bool empty() {
        if(q1.empty()) return true;
        else return false;
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */