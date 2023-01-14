class Solution {
    
    private char dfs(HashMap<Character, ArrayList<Character>> adj, char node, char parent, boolean[] vis){
        if(!adj.containsKey(node) || vis[node -'a']) return node;
        vis[node-'a'] = true;
        
        char min = node;
        for(char n : adj.get(node)){
            if(n == parent) continue;
            char minChild = dfs(adj, n, node, vis);
            if(minChild < min) min = minChild;
        }
        
        return min;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character, ArrayList<Character>> adj = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                adj.computeIfAbsent(s1.charAt(i), v -> new ArrayList<>()).add(s2.charAt(i));
                adj.computeIfAbsent(s2.charAt(i), v -> new ArrayList<>()).add(s1.charAt(i));
            }
        }
        String res = "";
        for(int i=0; i<baseStr.length(); i++){
            res += dfs(adj, baseStr.charAt(i), 'Z', new boolean[26]);
        }
        return res;
    }
}