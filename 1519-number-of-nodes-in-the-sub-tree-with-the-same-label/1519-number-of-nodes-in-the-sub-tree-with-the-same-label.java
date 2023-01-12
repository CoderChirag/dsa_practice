class Solution {
    
    public void dfs(HashMap<Integer, List<Integer>> adj, int node, int parent, char[] labels, HashMap<Character, Integer> map, int[] res){
        if(!adj.containsKey(node)) return;
        
        HashMap<Character, Integer> m = new HashMap<>();
        for(int n : adj.get(node)){
            if(n == parent) continue;
            
            // res[n] = map.getOrDefault(labels[node], 0)+1;
            m.clear();
            dfs(adj, n, node, labels, m, res);
            
            for(Map.Entry<Character, Integer> e : m.entrySet()){
                char c = e.getKey();
                int v = e.getValue();
                map.merge(c, v, (oldVal, newVal) -> oldVal + newVal);
            }
        }
        
        map.merge(labels[node], 1, (oldVal, newVal) -> oldVal + newVal);
        res[node] = map.get(labels[node]);
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        int[] res = new int[n];
        dfs(adj, 0, -1, labels.toCharArray(), new HashMap<>(), res);
        return res;
    }
}