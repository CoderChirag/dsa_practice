class Solution {
    
    public boolean isSafe(char[][] board, char n, int i, int j){
        for(int k=0; k<9; k++){
            if(board[i][k] == n || board[k][j] == n) return false;
        }
        int rs = i - i%3;
        int cs = j - j%3;
        for(int ii=0; ii<3; ii++){
            for(int jj=0; jj<3; jj++){
                if(board[ii+rs][jj+cs] == n) return false;
            }
        }
        return true;
    }
    
    public boolean solveRec(char[][] board) {
        int i=-1, j=-1;
        for(int ii=0; ii<9; ii++){
            for(int jj=0; jj<9; jj++){
                if(board[ii][jj] == '.'){
                    i = ii;
                    j = jj;
                    break;
                }
            }
        }
        if(i == -1 || j == -1) return true;
        for(int n=1; n<=9; n++){
            if(isSafe(board, Character.forDigit(n, 10), i, j)){
                board[i][j] = Character.forDigit(n, 10);
                if(solveRec(board)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
    
    public void solveSudoku(char[][] board){
        solveRec(board);
    }
}