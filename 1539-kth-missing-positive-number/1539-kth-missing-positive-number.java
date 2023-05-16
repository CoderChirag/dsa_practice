class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k == 0) return -1;
        int n = arr.length;
        if(k <= arr[0] - 1) return k;
        else k -= arr[0]-1;
        for(int i=1; i<n; i++){
            if(k <= arr[i]-arr[i-1]-1) return arr[i-1] + k;
            else k -= arr[i]-arr[i-1]-1;
        }
        return arr[n-1] + k;
    }
}