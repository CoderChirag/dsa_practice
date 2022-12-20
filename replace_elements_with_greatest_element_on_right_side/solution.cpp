class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int n = arr.size();
        int curr_leader = arr[n-1];
        arr[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            if(arr[i] > curr_leader){
                swap(arr[i], curr_leader);
            }else{
                arr[i] = curr_leader;
            }
        }
        return arr;
    }
};