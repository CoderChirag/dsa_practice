class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l = -1, r = 0, res = -1;
        for(int i=0; i<n; i++){
            if(weights[i] > l) l = weights[i];
            r += weights[i];
        }
        while(l <= r){
            int mid = l + (r-l)/2;
            int cap = 0, d = 0;
            int i = 0;
            while(i < n){
                while(i < n && cap + weights[i] <= mid){
                    cap += weights[i++];
                }
                d++;
                cap = 0;
            }
            if(d <= days){
                res = mid;
                r =  mid-1;
            }else l = mid+1;
        }
        return res;
    }
}