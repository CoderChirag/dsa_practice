class Solution {
public:
    bool check(int balls, vector<int>& position, int n, int distance){
        int cnt = 1, prev_pos = position[0];
        for(int i=1; i<n; i++){
            if(position[i]-prev_pos >= distance){
                prev_pos = position[i];
                cnt++;
            }
            if(cnt == balls) return true;
        }
        return false;
    }
    
    int maxDistance(vector<int>& position, int m) {
        int n = position.size();
        sort(position.begin(), position.end());
        int start = 0, end = position[n-1], ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(check(m, position, n, mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
};