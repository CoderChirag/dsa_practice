//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int u, int parent, int cnt, boolean vis[], int disc[], int low[], boolean isAP[]){
        disc[u] = low[u] = cnt;
        vis[u] = true;
        int cntForRoot = 0;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(adj, v, u, cnt+1, vis, disc, low, isAP);
                cntForRoot++;
                low[u] = Math.min(low[u], low[v]);
                if(parent != -1 && low[v] >= disc[u]) isAP[u] = true;
            }else if(v != parent){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        if(parent == -1 && cntForRoot > 1) isAP[u] = true;
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean vis[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean isAP[] = new boolean[V];
        ArrayList<Integer> al = new ArrayList<>();
        
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        
        dfs(adj, 0, -1, 1, vis, disc, low, isAP);
        
        for(int i=0; i<V; i++){
            if(isAP[i]) al.add(i);
        }
        return al.size() > 0 ? al : new ArrayList<>(Arrays.asList(-1));
    }
}