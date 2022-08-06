class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> row(numRows);
        for(int i=0; i<numRows; i++){
            int size = i+1;
            vector<int> col(size, 0);
            col[0] = 1;
            col[size-1] = 1;
            for(int j=1; j<size-1; j++){
                col[j] = row[i-1][j] + row[i-1][j-1];
            }
            row[i] = col;
        }
        return row;
    }
};