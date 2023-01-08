class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
        int res = 2;
        for(int i=0; i<n; i++){
            HashMap<Double, Integer> mp = new HashMap<>();
            for(int j=0; j<n; j++){
                if(j != i){
                    mp.merge(Math.atan2(points[j][1]-points[i][1], points[j][0]-points[i][0]), 1, Integer::sum);
                }
            }
            res = Math.max(res, Collections.max(mp.values())+1);
        }
        return res;
    }
}