/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    void dfs(Node* node, Node* nd, int parent, map<int, Node*>& vis){
        Node* n = nd;
        if(parent != -1){
            n = new Node(node->val);
            nd->neighbors.push_back(n);
            vis[node->val] = n;
        }
        for(auto it : node->neighbors){
            auto temp = vis.find(it->val);
            if(temp != vis.end()){
                n->neighbors.push_back(temp->second);
            }else{
                dfs(it, n, n->val, vis);
            }
        }
    }
    
    Node* cloneGraph(Node* node) {
        if(!node)
            return NULL;
        map<int, Node*> vis;
        Node* nd = new Node(node->val);
        vis[node->val] = nd;
        dfs(node, nd, -1, vis);
        return nd;
    }
};