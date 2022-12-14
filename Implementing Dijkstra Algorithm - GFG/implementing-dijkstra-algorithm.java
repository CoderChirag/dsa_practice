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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// Time Complexity: O(V*(V + V)) ~ O(V^2)
// class Solution
// {
//     //Function to find the shortest distance of all the vertices
//     //from the source vertex S.
//     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
//     {
//         // Write your code here
//         int dist[] = new int[V];
//         boolean fin[] = new boolean[V];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[S] = 0;
//         for(int i=0; i<V; i++){
//             int u = -1;
//             for(int j=0; j<V; j++){
//                 if(!fin[j] && (u == -1 || dist[j] < dist[u])) u = j;
//             }
//             for(ArrayList<Integer> ele : adj.get(u)){
//                 dist[ele.get(0)] = Math.min(dist[ele.get(0)], dist[u] + ele.get(1));
//             }
//             fin[u] = true;
//         }
//         return dist;
//     }
// }

class Pair implements Comparable<Pair>{
    int dist, node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
    
    @Override
    public int compareTo(Pair p){
        return Integer.compare(this.dist, p.dist);
    }
}

// Time Complexity: O(E*logV) (Explained below)
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dist[] = new int[V];
        boolean fin[] = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        q.offer(new Pair(0, S));
        while(!q.isEmpty()){ // Running O(V) times
            Pair p = q.poll(); // O(logV) Work
            if(!fin[p.node]){
                for(ArrayList<Integer> ele : adj.get(p.node)){ // Running k times, where k = no. of edges the current vertex is having
                    if(!fin[ele.get(0)] && dist[ele.get(0)] > p.dist + ele.get(1)){ // So overall the outer and this loop combined would be running 2E Times
                        dist[ele.get(0)] =  p.dist + ele.get(1);
                        q.offer(new Pair(ele.get(1)+p.dist, ele.get(0))); // O(logV)
                    }
                }
            }
            fin[p.node] = true;
        }
        return dist;
    }
}

