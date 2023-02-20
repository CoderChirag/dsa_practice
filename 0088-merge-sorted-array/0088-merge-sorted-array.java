class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int gap = (int) Math.ceil((double)(n+m)/2.0);
        while(gap > 0){
            int i = 0, j = gap;
            while(j < (n+m)){
                if(j < m && nums1[i] > nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                else if(j >=m && i<m && nums1[i] > nums2[j-m]){
                    int temp = nums1[i];
                    nums1[i] = nums2[j-m];
                    nums2[j-m] = temp;
                }
                else if(j >= m && i >= m && nums2[i-m] > nums2[j-m]){
                    int temp = nums2[i-m];
                    nums2[i-m] = nums2[j-m];
                    nums2[j-m] = temp;
                }
                j++;
                i++;
            }
            if(gap == 1) gap = 0;
            else gap = (int) Math.ceil((double)gap/2.0);
        }
        for(int i=0; i<n; i++){
            nums1[i+m] = nums2[i];
        }
    }
}