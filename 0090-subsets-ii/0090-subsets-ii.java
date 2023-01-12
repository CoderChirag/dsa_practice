class Solution {
    
    public void subsetsWithDupRec(int[] nums, int i, List<Integer> curr, HashSet<List<Integer>> res){
        if(i == nums.length){
            ArrayList<Integer> al = new ArrayList<>(curr);
            res.add(al);
            return;
        }
        
        curr.add(nums[i]);
        subsetsWithDupRec(nums, i+1, curr, res);
        curr.remove(curr.size()-1);
        subsetsWithDupRec(nums, i+1, curr, res);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        subsetsWithDupRec(nums, 0, new ArrayList<>(), res);
        List<List<Integer>> al = new ArrayList<>();
        for(List<Integer> list : res){
            al.add(list);
        }
        return al;
    }
}