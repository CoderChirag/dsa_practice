class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(mid == 0) return nums[mid] > nums[mid+1] ? mid : mid+1;
            if(mid == n-1) return nums[mid] > nums[mid-1] ? mid : mid-1;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid-1] > nums[mid]) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }
}