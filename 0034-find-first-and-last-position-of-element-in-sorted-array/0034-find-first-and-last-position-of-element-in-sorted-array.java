class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1, first = -1, last = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if((mid == 0 || nums[mid-1] < target) && nums[mid] == target){
                first = mid;
                break;
            }else if(nums[mid] < target) l = mid+1;
            else r = mid-1;
        }
        l = 0;
        r = n-1;
        while(l <= r){
            int mid = (l+r)/2;
            if((mid == n-1 || nums[mid+1] > target) && nums[mid] == target){
                last = mid;
                break;
            }else if(nums[mid] <= target) l = mid+1;
            else r = mid-1;
        }
        return new int[]{first, last};
    }
}