class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        bool is_col_zero = false;
        int m = matrix.size();
        int n = matrix[0].size();

        for (int i = 0; i < m; i++) {
            if (!matrix[i][0]) is_col_zero = true;

            for (int j = 1; j < n; j++) {
                if (!matrix[i][j]) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (!matrix[i][0] || !matrix[0][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (!matrix[0][0]) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (is_col_zero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        
    }
};