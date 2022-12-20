class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length;
        
        int low = 0, high = n, medianIdx = ((n+m)+1)/2;
        while(low <= high){
            int cut1 = (low + high)/2;
            int cut2 = medianIdx - cut1;
            
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1){
                if((n+m)%2 != 0) return Math.max(l1, l2);
                else return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            }else if(l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return 0.0;
    }
}