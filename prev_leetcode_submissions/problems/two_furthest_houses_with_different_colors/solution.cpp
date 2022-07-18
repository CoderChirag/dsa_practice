class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        int max_dist = -1;
        for(int i=1; i<colors.size(); i++){
            if(colors[i] != colors[0]){
                max_dist = max(max_dist, i - 0);
            }
        }
        for(int i=colors.size()-2; i>=0; i--){
            if(colors[i] != colors[n-1]){
                max_dist = max(max_dist, n-1-i);
            }
        }
        return max_dist > 0 ? max_dist : 0;
    }
};