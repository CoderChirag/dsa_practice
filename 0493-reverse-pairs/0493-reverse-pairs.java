class Solution {
//     O(N^2) - Time Limit Exceeded
    // public int reversePairs(int[] nums) {
    //     int n = nums.length, cnt = 0;
    //     for(int i=0; i<n; i++){
    //         for(int j=i+1; j<n; j++){
    //             if(nums[j] < (double)nums[i]/2.0) cnt++;
    //         }
    //     }
    //     return cnt;
    // }
    
    public int merge(int nums[], int l, int mid, int r){
        int temp[] = new int[r-l+1];
        int i = l, j = mid+1, k = 0, count = 0;
        for(; i<=mid; i++){
            while(j <= r && nums[i] > 2 * (long)nums[j]) j++;
            count += (j-(mid+1));
        }
        i = l;
        j = mid+1;
        while(i <= mid && j <= r){
            if(nums[j] <= nums[i]){  
                temp[k++] = nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= r){
            temp[k++] = nums[j++];
        }
        for(i=l,k=0; i<=r;i++,k++){
            nums[i] = temp[k];
        }
        return count;
        
    }

    public int mergeSort(int[] nums, int l, int r){
        int cnt = 0;
        if(l < r){
            int mid = (l+r)/2;
            cnt += mergeSort(nums, l, mid);
            cnt += mergeSort(nums, mid+1, r);
            cnt += merge(nums, l, mid, r);
        }
        return cnt;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}