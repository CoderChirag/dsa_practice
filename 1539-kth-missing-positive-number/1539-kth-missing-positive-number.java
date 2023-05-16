class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n-1;
        int res = -1;
        while(l <= r){
            int mid = (l+r)/2;
            int diff = arr[mid] - mid - 1;
            if(diff < k){
                res = arr[mid] + (k-diff);
                l = mid+1;
            }else r = mid-1;
        }
        return res == -1 ? k : res;
    }
}