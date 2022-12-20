class Solution {
public:
    static bool compare(vector<int> v1, vector<int> v2){
        return v1[1] > v2[1];
    }
    
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), compare);
        int res = 0, curr_cap = truckSize;
        for(int i=0; i<boxTypes.size(); i++){
            if(boxTypes[i][0] < curr_cap){
                res += boxTypes[i][0]*boxTypes[i][1];
                curr_cap -= boxTypes[i][0];
            }else{
                res += boxTypes[i][1]*curr_cap;
                return res;
            }
        }
        return res;
    }
};