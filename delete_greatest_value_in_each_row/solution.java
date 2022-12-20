class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        for(int i=0; i<m; i++){
            Arrays.sort(grid[i]);
        }
        
        int res = 0;
        for(int j=n-1; j>=0; j--){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<m; i++){
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        return res;
    }
}