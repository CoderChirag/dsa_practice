class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            long target1 = target - nums[i];
            for(int j=i+1; j<n; j++){
                long req = target1 - nums[j];
                int l = j+1, r = n-1;
                while(l < r){
                    long sum = nums[l] + nums[r];
                    if(sum < req) l++;
                    else if(sum > req) r--;
                    else{
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        res.add(quad);
                        
                        //                     Handling Duplicates
                    while(l < r && nums[l] == quad.get(2)) l++;
                    while(l < r && nums[r] == quad.get(3)) r--;
                    }
                
                }
                while(j+1 < n && nums[j+1] == nums[j]) j++;
            }
            while(i+1 < n && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
}