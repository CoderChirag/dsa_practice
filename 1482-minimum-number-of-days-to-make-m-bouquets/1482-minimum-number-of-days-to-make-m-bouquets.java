class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1;
        int res = -1;
        int l = 1, r = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i] >  r) r = bloomDay[i];
        }
        while(l <= r){
            int mid = l + (r-l)/2;
            int boquets = 0, adj_flowers = 0;
            for(int i=0; i<n; i++){
                if(i == 0 || bloomDay[i-1] > mid) adj_flowers = 0;
                if(mid >= bloomDay[i]) adj_flowers++;
                if(adj_flowers == k){
                    boquets++;
                    adj_flowers = 0;
                }
            }
            if(boquets >= m){
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return res;
    }
}