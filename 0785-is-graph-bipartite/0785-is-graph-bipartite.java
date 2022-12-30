// My Solution - DFS Based 
// class Solution {
    
//     HashSet<Integer> set0;
//     HashSet<Integer> set1;
    
//     public boolean dfs1(int[][] graph, int u, boolean vis[]){
//         vis[u] = true;
//         for(int v : graph[u]){
//             if(!vis[v]){
//                 set0.add(v);
//                 if(!dfs0(graph, v, vis)) return false;
//             }else if(set1.contains(v)) return false;
//         }
//         return true;
//     }
    
//     public boolean dfs0(int[][] graph, int u, boolean vis[]){
//         vis[u] = true;
//         for(int v : graph[u]){
//             if(!vis[v]){
//                 set1.add(v);
//                 if(!dfs1(graph, v, vis)) return false;
//             }else if(set0.contains(v)) return false;
//         }
//         return true;
//     }
    
//     public boolean isBipartite(int[][] graph) {
//         set0 = new HashSet<>();
//         set1 = new HashSet<>();
//         int V = graph.length;
//         boolean vis[] = new boolean[V];
//         for(int i=0; i<V; i++){
//             if(!vis[i]){
//                 set0.add(i);
//                 if(!dfs0(graph, i, vis)) return false;
//             }
//         }
//         return true;
//     }
// }

// Efficient Approach - DFS Based

class Solution {
    
    public boolean dfs(int[][] graph, int u, int col, int color[]){
        color[u] = col;
        for(int v : graph[u]){
            if(color[v] == -1){
                if(!dfs(graph, v, col==0?1:0, color)) return false;
            }else if(color[v] == color[u]) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);
        
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(!dfs(graph, i, 0, color)) return false;
            }
        }
        return true;
    }
}