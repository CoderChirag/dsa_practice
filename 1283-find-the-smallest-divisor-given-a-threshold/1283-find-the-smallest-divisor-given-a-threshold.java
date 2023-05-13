class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l = 1, r = 1_000_000_000;
        int res = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            long sum = 0;
            for(int i=0; i<n; i++){
                sum += Math.ceil(nums[i]/(double)mid);
            }
            if(sum <= threshold){
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return res;
    }
}