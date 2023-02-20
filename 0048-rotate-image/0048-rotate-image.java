class Solution {
    
    public void swap(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
    
    public void reverse(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            int l = 0, r = n-1;
            while( l < r){
                swap(matrix, i, l, i, r);
                l++;
                r--;
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=i; j<n; j++){
                swap(matrix, i, j, j, i);
            }
        }
        reverse(matrix);
    }
}