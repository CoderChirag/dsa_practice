class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > nums[l]){
                if(target >= nums[l] && target < nums[mid]) r = mid-1;
                else l = mid+1;
            }else if(nums[mid] < nums[l]){
                if(target > nums[mid] && target <= nums[r]) l = mid+1;
                else r = mid-1;
            }else if(nums[mid] == nums[l]){
                l++;
            }
        }
        return false;
    }
}