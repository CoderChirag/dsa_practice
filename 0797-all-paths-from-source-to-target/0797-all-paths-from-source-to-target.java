class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(graph,list,res,0);
        return res;        
    }
    public void dfs(int[][] graph,List<Integer> list,List<List<Integer>> res,int curr){
        if(curr==graph.length-1){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int x:graph[curr]){
            list.add(x);
            dfs(graph,list,res,x);
            list.remove(list.size()-1);
        }
    }
}