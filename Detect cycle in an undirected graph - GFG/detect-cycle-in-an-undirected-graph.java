//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// DFS Based Approach
// class Solution {
//     public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int v, int parent){
//         visited[v] = true;
//         for(int e : adj.get(v)){
//             if(!visited[e]){
//                 if(dfs(adj, visited, e, v)) return true;
//             }
//             else if(e != parent) return true;
//         }
//         return false;
//     }
    
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         boolean visited[] = new boolean[V];
//         for(int i=0; i<V; i++){
//             if(!visited[i]){
//                 if(dfs(adj, visited, i, -1)) return true;
//             }
//         }
//         return false;
//     }
// }

// BFS Based Approach
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        int parents[] = new int[V];
        Arrays.fill(parents, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                q.offer(i);
                vis[i] = true;
                parents[i] = -1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int it : adj.get(node)){
                        if(!vis[it]){
                            vis[it] = true;
                            q.offer(it);
                            parents[it] = node;
                        }else if(parents[node] != it) return true;
                    }
                }       
            }
        }
        return false;
    }
}
