class Solution {
    void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n-1;
        while(i > 0 && nums[i-1] >= nums[i]) i--;
        if(i == 0){
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