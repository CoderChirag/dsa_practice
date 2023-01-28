class Solution {
    
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i = n-1;
        while(i > 0 && nums[i] <= nums[i-1]) i--;
        if(i == 0 ){
            reverse(nums, 0, n-1);
            return;
        }
        int j = i-1;
        while(i < n && nums[i] > nums[j]) i++;
        
        int temp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = temp;
        
        reverse(nums, j+1, n-1);
        
    }
}