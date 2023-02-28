class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = (m*n)-1;
        while(l <= r){
            int mid = (l + r)/2;
            int i = mid/n, j = mid%n;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}