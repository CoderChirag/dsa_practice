//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


// Time Complexity: O(V+E)
class Solution
{
    //Function to find number of strongly connected components in the graph.
    void dfs(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> st, boolean vis[]){
        vis[v] = true;
        for(int u : adj.get(v)){
            if(!vis[u]) dfs(adj, u, st, vis);
        }
        st.push(v);
    }
    
    void revDfs(ArrayList<ArrayList<Integer>> transpose, int v, boolean vis[]){
        vis[v] = true;
        for(int u : transpose.get(v)){
            if(!vis[u]) revDfs(transpose, u, vis);
        }
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]) dfs(adj, i, st, vis);
        }
        
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        int res = 0;
        
        for(int i=0; i<V; i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            vis[i] = false;
            for(int e : adj.get(i)){
                transpose.get(e).add(i);
            }
        }
        
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                revDfs(transpose, node, vis);
                res++;
            }
        }

        return res;
    }
}
