class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            long target1 = target-nums[i];
            for(int j=i+1; j<n; j++){
                long target2 = target1-nums[j];
                int l = j+1, r = n-1;
                while(l < r){
                    if(nums[l] + nums[r] == target2){
                        ArrayList<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        
                        res.add(quad);
                        
                        while(l < r && nums[l] == quad.get(2))l++;
                        while(l < r && nums[r] == quad.get(3)) r--;
                        
                    }else if(nums[l] + nums[r] < target2)l++;
                    else r--;
                }
                while(j < n-1 && nums[j] == nums[j+1]) j++;
            }
            while(i < n-1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}