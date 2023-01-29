//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Pair implements Comparable<Pair>{
    int node, dist;
    Pair(int n, int d){
        node = n;
        dist = d;
    }
    
    @Override
    public int compareTo(Pair p){
        return Integer.compare(dist, p.dist);
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	    for(int i=0; i<V; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0; i<edges.length; i++){
	        adj.get(edges[i][0]).add(new ArrayList<>(Arrays.asList(edges[i][1], edges[i][2])));
	        adj.get(edges[i][1]).add(new ArrayList<>(Arrays.asList(edges[i][0], edges[i][2])));
	    }
	    
	    int res = 0;
	    boolean inMST[] = new boolean[V];
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    pq.offer(new Pair(0, 0));
	    
	    while(!pq.isEmpty()){
	        Pair p = pq.poll();
	        int u = p.node, d = p.dist;
	        
	        if(!inMST[u]){
	            res += d;
	            for(ArrayList<Integer> al : adj.get(u)){
	                int v = al.get(0), w = al.get(1);
	                if(!inMST[v]){
	                    pq.offer(new Pair(v, w));
	                }
	            }
	        }
	        inMST[u] = true;
	    }
	    return res;
	}
}