class Solution {
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void permuteRec(int[] nums, int l, int r, List<List<Integer>> res){
        if(l==r){
            List<Integer> al = new ArrayList<>();
            for(int i=0; i<=r; i++){
                al.add(nums[i]);
            }
            res.add(al);
            return;
        }
        for(int i=l; i<=r; i++){
            swap(nums, l, i);
            permuteRec(nums, l+1, r, res);
            swap(nums, l, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteRec(nums, 0, nums.length-1, res);
        return res;
    }
}