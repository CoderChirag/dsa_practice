class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i=0, j=0;
        while(i<m+n && j<n){
            while(nums1[i] <= nums2[j] && i<m+j) i++;
            int temp = m+j;
            while(temp > i){
                nums1[temp] = nums1[temp-1];
                temp--;
            };
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }
};