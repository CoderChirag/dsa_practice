class Solution {
    
    int maxPathLen = 1;
    
    public int dfs(HashMap<Integer, ArrayList<Integer>> adj, int node, char[] s){
        if(!adj.containsKey(node)) return 1;
        int path1 = 0, path2 = 0;
        for(int n : adj.get(node)){
            int path = dfs(adj, n, s);
            if(s[node] == s[n]) continue;
            if(path > path1){
                path2 = path1;
                path1 = path;
            }else if(path > path2) path2 = path;
        }
        
        maxPathLen = Math.max(maxPathLen, path1+path2+1);
        return  path1 + 1;
    }
    
    public int longestPath(int[] parent, String s) {
        maxPathLen = 1;
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=1; i<parent.length; i++){
            adj.computeIfAbsent(parent[i], v-> new ArrayList<>()).add(i);
        }
        dfs(adj, 0, s.toCharArray());
        return maxPathLen;
    }
}