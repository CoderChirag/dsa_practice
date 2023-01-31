class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int min_i = 0, min_j = 0, max_i = m, max_j = n;
        int count = 0;
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while(count < m*n){
            for(i=min_i,j=min_j;j<max_j;j++){
                res.add(matrix[i][j]);
                count++;
            }
            if(count == m*n) break;
            min_i++;
            for(i=min_i,j=max_j-1;i<max_i;i++){
                res.add(matrix[i][j]);
                count++;
            }
            if(count == m*n) break;
            max_j--;
            for(i=max_i-1,j=max_j-1;j>=min_j;j--){
                res.add(matrix[i][j]);
                count++;
            }
            if(count == m*n) break;
            max_i--;
            for(i=max_i-1,j=min_j;i>=min_i;i--){
                res.add(matrix[i][j]);
                count++;
            }
            min_j++;
        }
        return res;
    }
}