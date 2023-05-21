class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (l+r)/2;
            if((mid == 0 || nums[mid-1] != nums[mid]) && (mid == n-1 || nums[mid+1] != nums[mid])) return nums[mid];
            else if((mid%2 != 0 && nums[mid-1] == nums[mid]) || (mid%2 == 0 && nums[mid+1] == nums[mid])) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
}