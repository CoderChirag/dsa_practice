class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> ans(rowIndex+1, 1);
        vector<int> prev(rowIndex+1, 1);
        for(int i=0; i<=rowIndex; i++){
            for(int j=0; j<=i; j++){
                if(j && j<i){
                    ans[j] = prev[j-1] + prev[j];
                }
            }
            prev = ans;
        }
        return ans;
    }
};