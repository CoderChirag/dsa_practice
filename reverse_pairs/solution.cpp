class Solution {
public:
    int merge(vector<int> &arr, int start, int mid, int end){
        int temp[end-start];
        int count = 0;
        int i=start, j=mid, k=0;
        while(i<mid){
            while(j < end && arr[i] > 2LL*arr[j]){
                j++;
            }
            count += (j-mid);
            i++;
        }
        i = start, j = mid;
        while(i<mid && j<end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i < mid) temp[k++] = arr[i++];
        while(j < end) temp[k++] = arr[j++];
        for(k=0; k<(end-start); k++){
            arr[k+start] = temp[k];
        }
        return count;
    }
    int mergeSort(vector<int> &arr, int start, int end){
        int count = 0;
        if(start < end-1){
            int mid = (start+end)/2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }
    int reversePairs(vector<int>& nums) {
        return mergeSort(nums, 0, nums.size());
    }
};