class Solution {
    
    public boolean isSafe(int board[][], int n, int row, int col){
        for(int j=0; j<col; j++)
            if(board[row][j] == 1) return false;
        for(int i=row, j=col; i>=0 && j>=0; i--, j--)
            if(board[i][j] == 1) return false;
        for(int i=row, j=col; i<n && j>=0; i++,j--)
            if(board[i][j] == 1) return false;
        return true;
    }
    
    public void solveRec(int board[][], int n, int col, List<List<String>> res){
        if(col == n){
            List<String> al = new ArrayList<>();
            for(int i=0; i<n; i++){
                String str = "";
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1) str += "Q";
                    else str += ".";
                }
                al.add(str);
            }
            res.add(al);
            return;
        }
        for(int i=0; i<n; i++){
            if(isSafe(board, n, i, col)){
                board[i][col] = 1;
                solveRec(board, n, col+1, res);
                board[i][col] = 0;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        int board[][] = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        solveRec(board, n, 0, res);
        return res;
    }
}