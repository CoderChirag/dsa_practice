//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] topologicalSort(LinkedList<Integer>[] adj, int V){
        int res[] = new int[V], in[] = new int[V];
        int k = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(LinkedList<Integer> li : adj){
            for(int v : li){
                in[v]++;
            }
        }
        for(int i=0; i<V; i++){
            if(in[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int v = q.poll();
            res[k++] = v;
            for(int u : adj[v]){
                in[u]--;
                if(in[u] == 0) q.offer(u);
            }
        }
        return res;
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        LinkedList<Integer> adj[] = new LinkedList[K];
        
        for(int i=0; i<K; i++){
            adj[i] = new LinkedList<>();
        }
        
        for(int i=0; i<N-1; i++){
            for(int j=0; j<Math.min(dict[i].length(), dict[i+1].length()); j++){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj[dict[i].charAt(j) - 'a'].add(dict[i+1].charAt(j) - 'a');
                    break;
                }
            }
        }
        
        int[] top = topologicalSort(adj, K);
        char sorted[] = new char[top.length]; 
        for(int i=0; i<top.length; i++){
            sorted[i] = 'a';
            sorted[i] += top[i];
        }
        String res = new String(sorted);
        // System.out.println(res);
        return res;
    }
}