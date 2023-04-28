class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (l+r)/2;
            int max_row = 0;
            for(int i=0; i<m; i++){
                if(mat[max_row][mid] < mat[i][mid]) max_row = i;
            }
            if((mid == 0 || mat[max_row][mid] > mat[max_row][mid-1]) && (mid == n-1 || mat[max_row][mid] > mat[max_row][mid+1])) return new int[]{max_row, mid};
            else if(mid > 0 && mat[max_row][mid-1] > mat[max_row][mid]) r = mid-1;
            else l = mid+1;
        }
        return new int[]{-1, -1};
    }
}