class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int min_row = 0, max_row = m-1;
        while(min_row <= max_row){
            int mid_row = (min_row + max_row)/2;
            if(target >= matrix[mid_row][0] && target <= matrix[mid_row][n-1]){
                int min_col = 0, max_col = n-1;
                while(min_col <= max_col){
                    int mid_col = (min_col + max_col)/2;
                    if(matrix[mid_row][mid_col] == target) return true;
                    else if(matrix[mid_row][mid_col] < target) min_col = mid_col+1;
                    else max_col = mid_col-1;
                }
                return false;
            }else if(target < matrix[mid_row][0]) max_row = mid_row-1;
            else if(target > matrix[mid_row][n-1]) min_row = mid_row + 1;
        }
        return false;
    }
}