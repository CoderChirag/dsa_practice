class Solution {
public:
    int findDuplicate(vector<int>& arr) {
        int n = arr.size();
        int res = 0;
        for(int i=0; i<n; i++){
            if(arr[(arr[i]%(n+1))-1]/(n+1)){
                res = (arr[i]%(n+1));
                break;
            }else arr[(arr[i]%(n+1))-1] += n+1;
        }
        for(int i=0; i<n; i++){
            arr[i] /= (n+1);
        }
        return res;
        
    }
};