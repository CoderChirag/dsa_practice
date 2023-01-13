class Solution {
    
    private void backtrack(int[] candidates,
                           LinkedList<Integer> comb,
                           int target, int currIndex,
                           List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = currIndex; i < candidates.length; i++) {
            if(i > currIndex && candidates[i] == candidates[i-1]) continue;
            
            int cand = candidates[i];

            if (target >= cand){
                comb.addLast(cand);
                backtrack(candidates, comb, target - cand, i+1, res);
                comb.removeLast();
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(candidates, new LinkedList<>(), target, 0, res);
        return res;
    }
}