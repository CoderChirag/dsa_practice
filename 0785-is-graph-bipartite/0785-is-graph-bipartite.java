class Solution {
    
    HashSet<Integer> set0;
    HashSet<Integer> set1;
    
    public boolean dfs1(int[][] graph, int u, boolean vis[]){
        vis[u] = true;
        for(int v : graph[u]){
            if(!vis[v]){
                set0.add(v);
                if(!dfs0(graph, v, vis)) return false;
            }else if(set1.contains(v)) return false;
        }
        return true;
    }
    
    public boolean dfs0(int[][] graph, int u, boolean vis[]){
        vis[u] = true;
        for(int v : graph[u]){
            if(!vis[v]){
                set1.add(v);
                if(!dfs1(graph, v, vis)) return false;
            }else if(set0.contains(v)) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        set0 = new HashSet<>();
        set1 = new HashSet<>();
        int V = graph.length;
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                set0.add(i);
                if(!dfs0(graph, i, vis)) return false;
            }
        }
        return true;
    }
}