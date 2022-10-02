class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        int n = arr.size();
        int ans = 1;
        int anchor = 0;
        for(int i=1; i<n; i++){
            int c = arr[i-1] < arr[i] ? -1 : arr[i-1] > arr[i] ? 1 : 0;
            int cNot = 1;
            if(i != n-1){
                cNot = arr[i] < arr[i+1] ? -1 : arr[i] > arr[i+1] ? 1 : 0;
            }
            if(c == 0){
                anchor = i;
            }else if(i == n-1 || c*cNot != -1){
                ans = max(ans, i-anchor+1);
                anchor = i;
            }
        }
        return ans;
    }
};