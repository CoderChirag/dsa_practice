class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a1, a2) -> Integer.compare(a1[1], a2[1]));
        int res = 1;
        int prev = points[0][1];
        for(int i=1; i<points.length; i++){
            if(prev < points[i][0]){
                prev = points[i][1];
                res++;
            }
        }
        return res;
    }
}