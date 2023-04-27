class Solution {
    
    public int merge(int nums[], int l, int mid, int r){
        int temp[] = new int[(r-l+1)];
        int i = l, j = mid+1, k = 0, count = 0;
        while(i <= mid && j <= r){
            if(nums[i] > 2*(long)nums[j]){
                count += mid-i+1;
                j++;
            }else i++;
        }
        i = l;
        j = mid+1;
        while(i <= mid && j <= r){
            if(nums[i] > nums[j]) temp[k++] = nums[j++];
            else temp[k++] = nums[i++];
        }
        while(i <=  mid) temp[k++] = nums[i++];
        while(j <= r) temp[k++] = nums[j++];
        
        for(k=0; k<(r-l+1); k++) nums[k+l] = temp[k];
        return count;
    }
    
    public int mergeSort(int[] nums, int l, int r){
        int count = 0;
        if(l < r){
            int mid = (l+r)/2;
            count += mergeSort(nums, l, mid);
            count += mergeSort(nums, mid+1, r);
            count += merge(nums, l, mid, r);
        }
        return count;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}