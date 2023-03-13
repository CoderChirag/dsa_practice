class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            int req = 0-nums[i];
            int l = i+1, r = n-1;
            while(l < r){
                if(nums[l]+nums[r] < req) l++;
                else if(nums[l]+nums[r] > req) r--;
                else {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    res.add(triplet);
                    while(l < r && nums[l] == triplet.get(1)) l++;
                    while(l<r && nums[r] == triplet.get(2)) r--;
                }
            }
            while(i+1 < n && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}