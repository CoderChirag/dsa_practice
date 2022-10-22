class LRUCache {
public:
    class node{
    public:
        int key;
        int val;
        node* prev;
        node* next;
        
        node(int _key, int _val){
            key = _key;
            val = _val;
            // prev = next = NULL;
        }
    };
    
    node* head = new node(-1, -1);
    node* tail = new node(-1, -1);
    
    int cap;
    unordered_map<int, node*> cache;
    
    LRUCache(int capacity) {
        ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
        cap = capacity;
        head->next = tail;
        tail->prev = head;
    }

    int get(int key_) {
        if(cache.find(key_) == cache.end()) return -1;
        
        node* resNode = cache[key_];
        int res = resNode->val;
        // remove from current position
        node* temp = resNode->prev;
        resNode->next->prev = temp;
        temp->next = resNode->next;
        
        // add it to front
        node* hnext = head->next;
        head->next = resNode;
        resNode->prev = head;
        hnext->prev = resNode;
        resNode->next = hnext;
        return res;
    }
    
    void put(int key_, int val) {
        if(cache.find(key_) != cache.end()){
            node* currNode = cache[key_];
            // remove from curr position
            node* temp = currNode->prev;
            currNode->next->prev = temp;
            temp->next = currNode->next;
            currNode->val = val;
            
            // add it to front
            node* hnext = head->next;
            head->next = currNode;
            currNode->prev = head;
            hnext->prev = currNode;
            currNode->next = hnext;
            cache[key_] = currNode;
        }else if(cache.size() < cap){
            // add new to front
            node* hnext = head->next;
            node* newNode = new node(key_, val);
            newNode->next = hnext;
            newNode->prev = head;
            head->next = newNode;
            hnext->prev = newNode;
            cache[key_] = newNode;
        }else{
            // add new to front
            node* hnext = head->next;
            node* newNode = new node(key_, val);
            newNode->next = hnext;
            newNode->prev = head;
            head->next = newNode;
            hnext->prev = newNode;
            cache[key_] = newNode;
            
            // remove last one            
            node* delNode = tail->prev;
            cache.erase(delNode->key);
            delNode->prev->next = tail;
            tail->prev = delNode->prev;
            delete delNode;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */