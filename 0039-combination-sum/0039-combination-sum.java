class Solution {
    
    public void combinationSumRec(int[] candidates, int target, int currSum, int currIndex, List<Integer> curr, List<List<Integer>> res){
        if(currSum == target){
            List<Integer> al = new ArrayList<>(curr);
            res.add(al);
            return;
        }
        
        for(int i=currIndex; i<candidates.length; i++){
            if(currSum+candidates[i] <= target){
                curr.add(candidates[i]);
                currSum += candidates[i];
                combinationSumRec(candidates, target, currSum, i, curr, res);
                curr.remove(curr.size()-1);
                currSum -= candidates[i];
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumRec(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }
}