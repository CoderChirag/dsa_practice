class Solution {
    
    public void combinationSumRec(int[] candidates, int target, List<Integer> curr, HashSet<List<Integer>> res){
        if(target == 0){
            List<Integer> al = new ArrayList<>(curr);
            Collections.sort(al);
            res.add(al);
            return;
        }
        
        for(int i=0; i<candidates.length; i++){
            if(target >= candidates[i]){
                curr.add(candidates[i]);
                combinationSumRec(candidates, target-candidates[i], curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        combinationSumRec(candidates, target, new ArrayList<>(), res);
        List<List<Integer>> al = new ArrayList<>(res);
        return al;
    }
}