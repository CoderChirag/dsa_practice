class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        int indegree[numCourses];
        for(int i=0; i<numCourses; i++){
            indegree[i] = 0;
        }
        vector<int> adj[numCourses];
        for(int i=0; i<prerequisites.size(); i++){
            adj[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        for(int i=0; i<numCourses; i++){
            for(int j=0; j<adj[i].size(); j++){
                indegree[adj[i][j]]++;
            }
        }
        queue<int> q;
        vector<int> res;
        for(int i=0; i<numCourses; i++){
            if(!indegree[i]){
                q.push(i);
            }
        }
        int count = 0;
        while(!q.empty()){
            int u = q.front();
            q.pop();
            for(auto it : adj[u]){
                indegree[it]--;
                if(!indegree[it]){
                    q.push(it);
                }
            }
            res.push_back(u);
            count++;
        }
        if(count < numCourses) res.clear();
        return res;
    }
};