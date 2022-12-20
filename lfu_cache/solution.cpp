class Node{
    public:
    int key, val, freq;
    Node* prev, *next;
    Node(int _key, int _val){
        key = _key;
        val = _val;
        prev = next = NULL;
        freq = 1;
    }
};

class List{
    public:
    Node* head = new Node(-1, -1);
    Node* tail = new Node(-1, -1);
    int size;
    List(){
        head->next = tail;
        tail->prev = head;
        size = 0;
    }

    bool empty(){
        return size == 0 ? true : false;
    }

    void addNode(Node* newNode){
        Node* tmp = head->next;
        head->next = newNode;
        newNode->prev = head;
        newNode->next = tmp;
        tmp->prev = newNode;
        size++;
    }

    void deleteNode(Node* delNode){
        Node* delNext = delNode->next;
        Node* delPrev = delNode->prev;
        delNext->prev = delPrev;
        delPrev->next = delNext;
        size--;
    }
};

class LFUCache {
public:
    unordered_map<int, List*> freqList;
    unordered_map<int, Node*> cache;
    int cap;
    int least_freq;
    LFUCache(int capacity) {
        ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
        cap = capacity;
        least_freq = 0;
    }
    
    void updateFreqList(Node* node){
        int freq = node->freq;
        freqList[freq]->deleteNode(node);
        if(least_freq == freq && freqList[freq]->empty()) least_freq++;
        (node->freq)++;
        freq++;
        if(freqList.find(freq) == freqList.end()){
            freqList[freq] = new List();
        }
        freqList[freq]->addNode(node);
    }
    
    int get(int key) {
        if(cache.find(key) != cache.end()){
            Node* resNode = cache[key];
            int res = resNode->val;
            updateFreqList(resNode);
            return res;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(cap == 0) return;
        if(cache.find(key) != cache.end()){
            Node* node = cache[key];
            node->val = value;
            updateFreqList(node);
        }else{
            if(cache.size() == cap){
                List* list = freqList[least_freq];
                Node* delNode = list->tail->prev;
                cache.erase(delNode->key);
                list->deleteNode(delNode);
            }
            least_freq = 1;
            if(freqList.find(1) == freqList.end()) freqList[1] = new List();
            Node* newNode = new Node(key, value);
            cache[key] = newNode;
            freqList[1]->addNode(newNode);
        }
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */