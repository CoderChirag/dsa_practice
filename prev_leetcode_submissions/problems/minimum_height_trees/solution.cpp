class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if(n < 2){
            vector<int> res;
            for(int i=0; i<n; i++){
                res.push_back(i);
            }
            return res;
        }
        vector<int> adj[n];
        int degree[n];
        for(int i=0; i<n; i++){
            degree[i] = 0;
        }
        for(int i=0; i<edges.size(); i++){
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        vector<int> leaves;
        for(int i=0; i<n; i++){
            if(degree[i] == 1){
                leaves.push_back(i);
            }
        }
        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            vector<int> newLeaves;
            for(auto leaf : leaves){
                degree[leaf]--;
                for(auto it : adj[leaf]){
                    degree[it]--;
                    if(degree[it] == 1)
                        newLeaves.push_back(it);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
        
    }
};