class Solution {
public:
    static bool compare(vector<int>& v1, vector<int>& v2){
        return v1[1] < v2[1];
    }
    
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size() <= 1)
            return points.size();
        
        sort(points.begin(), points.end(), compare);
        int last = points[0][1];
        int ans = 1;
        for(int i=1; i<points.size(); i++){
            if(last < points[i][0]){
                last = points[i][1];
                ans++;
            }
        }
        return ans;
    }
};