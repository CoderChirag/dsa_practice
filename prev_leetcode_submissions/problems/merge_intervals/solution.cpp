class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b)->bool{return a[0] < b[0];});
        res.push_back(intervals[0]);
        for(int i=1; i<intervals.size(); i++){
            if(res[res.size()-1][1] >= intervals[i][0]){
                vector<int> temp;
                if(res[res.size()-1][1] < intervals[i][1]){
                    temp.push_back(res[res.size()-1][0]);
                    temp.push_back(intervals[i][1]);
                }else{
                    temp.push_back(res[res.size()-1][0]);
                    temp.push_back(res[res.size()-1][1]);
                }
                res.pop_back();
                res.push_back(temp);
            }else{
                res.push_back(intervals[i]);
            }
        }
        return res;
    }
};