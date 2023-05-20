class Solution {
    public boolean isPossible(int[] nums, int k, int max_sum){
        int curr_sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max_sum) return false;
            if(nums[i] + curr_sum <= max_sum){
                curr_sum += nums[i];
            }else{
                k--;
                curr_sum = nums[i];
            }
        }
        return k > 0;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        for(int i=0; i<n; i++){
            r += nums[i];
        }
        int res = r;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(isPossible(nums, k, mid)){
                // System.out.println(mid);
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return res;
    }
}