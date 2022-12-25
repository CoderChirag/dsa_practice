class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        //first sort the array as odder doesn't matter in subsequence
        Arrays.sort(nums);
        
        //create prefixsum 
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int q = queries[i];
            
            int l=0,r=nums.length-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(nums[mid]==q){
                    ans[i]=mid+1;
                   break;
                }
                else if(nums[mid] < q) {
                    ans[i] = mid + 1;
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
       return ans; 
    }
}