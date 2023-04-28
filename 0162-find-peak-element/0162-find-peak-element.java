class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i != 0 && i != n-1){
                if((nums[i-1] < nums[i]) && (nums[i+1] < nums[i])) return i;
            }else if(i == 0 && (i == n-1 || nums[i+1] < nums[i])) return i;
            else if(i == n-1 && (i == 0 || nums[i-1] < nums[i])) return i;
            
        }
        return 0;
    }
}