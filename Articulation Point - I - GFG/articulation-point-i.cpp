//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int count = 0;
    void dfs(vector<int> adj[], int s, int parent, bool visited[], vector<int>& disc,  vector<int>& low, int isArticulationPoint[]){
        disc[s] = low[s] = count++;
        visited[s] = true;
        int countForRootEle = 0;
        for(auto it : adj[s]){
            if(!visited[it]){
                dfs(adj, it, s, visited, disc, low, isArticulationPoint);
                countForRootEle++;
                low[s] = min(low[s], low[it]);
                if(parent != -1 && low[it] >= disc[s]){
                    isArticulationPoint[s]++; 
                }
            }else if(it != parent){
                low[s] = min(low[s], disc[it]);
            }
        }
        if(parent == -1 && countForRootEle > 1)
            isArticulationPoint[s]++;
                
        
    }
  
    vector<int> articulationPoints(int V, vector<int>adj[]) {
        // Code here
        bool visited[V]{false};
        vector<int> disc(V, -1); 
        vector<int> low(V, -1);
        int isArticulationPoint[V]{0};
        dfs(adj, 0, -1, visited, disc, low, isArticulationPoint);
        vector<int> res;
        for(int i=0; i<V; i++){
            if(isArticulationPoint[i])
                res.push_back(i);
        }
        if(res.size() == 0)
            return {-1};
        return res;
    }
};

//{ Driver Code Starts.

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		vector<int> ans = obj.articulationPoints(V, adj);
		for(auto i: ans)cout << i << " ";
		cout << "\n";
	}
	return 0;
}
// } Driver Code Ends