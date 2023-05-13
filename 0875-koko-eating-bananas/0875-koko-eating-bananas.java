class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1, r = 0;
        int res = -1;
        for(int i=0; i<n; i++){
            if(piles[i] > r) r = piles[i];
        }
        while(l<= r){
            int mid = l + (r-l)/2;
            long req_hours = 0;
            for(int i = 0; i<n; i++){
                req_hours += Math.ceil(piles[i]/(double)mid);
            }
            if(req_hours <= h){
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return res;
    }
}