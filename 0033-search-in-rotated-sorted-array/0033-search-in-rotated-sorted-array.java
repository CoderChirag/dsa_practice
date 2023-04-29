class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <=r){
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            else if(nums[l] <= nums[mid]){  // Left Array is Sorted
                if(nums[l] <= target && nums[mid] >= target) r = mid-1;
                else l = mid+1;
            }else{ // Left array is unsorted and Right array is Sorted
                if(nums[mid] <= target && nums[r] >= target) l = mid+1;
                else r = mid-1;
            }
        }
        return -1;
    }
}