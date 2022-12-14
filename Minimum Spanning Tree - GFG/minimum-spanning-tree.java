//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Time Complexity: O(V*(V + V)) ~ O(V^2)
// class Solution
// {
//     //Function to find sum of weights of edges of the Minimum Spanning Tree.
//     static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
//     {
//         // Add your code here
//         int weights[] = new int[V];
//         Arrays.fill(weights, Integer.MAX_VALUE);
//         weights[0] = 0;
//         int res = 0;
//         boolean included[] = new boolean[V];
//         for(int i=0; i<V; i++){
//             int u = -1;
//             for(int j=0; j<V; j++){
//                 if(!included[j] && (u == -1 || weights[j] < weights[u] ) ){
//                     u = j;
//                 }
//             }
//             for(ArrayList<Integer> e : adj.get(u)){
//                 int v = e.get(0), w = e.get(1);
//                 if(!included[v] && weights[v] > w)
//                     weights[v] = w;
//             }
//             included[u] = true;
//             res += weights[u];
//         }
//         return res;
//     }
// }

class Pair implements Comparable<Pair>{
    int weight, node;
    Pair(int w, int n){
        weight = w;
        node = n;
    }
    
    @Override
    public int compareTo(Pair p){
        return Integer.compare(this.weight, p.weight);
    }
}
// Time Complexity: O((V+E)*logV) ~ O(V^2*logV) if graph is complete and O(E*logV) in when graph is not complete 
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<Pair> q = new PriorityQueue<>();
        boolean included[] = new boolean[V];
        int res = 0;
        q.offer(new Pair(0, 0));
        while(!q.isEmpty()){
            Pair u = q.poll();
            if(!included[u.node]){
                for(ArrayList<Integer> e : adj.get(u.node)){
                    int v = e.get(0), w = e.get(1);
                    if(!included[v])
                        q.offer(new Pair(w, v));
                }
                res += u.weight;
                included[u.node] = true;
            }
        }
        return res;
    }
}
