class Solution {
//     O(N*logN) Time and O(1) Space
    // public int longestConsecutive(int[] nums) {
    //     int n = nums.length, curr = 1, max = 1;
    //     if(n == 0) return 0;
    //     Arrays.sort(nums);
    //     for(int i=1; i<n; i++){
    //         if(nums[i] - nums[i-1] == 0) continue;
    //         else if(nums[i]-nums[i-1] == 1) curr++;
    //         else{
    //             max = Math.max(max, curr);
    //             curr = 1;
    //         }
    //     }
    //     max = Math.max(max, curr);
    //     return max;
    // }
    
//  O(N) Time and O(N) Space   
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(!set.contains(num-1)){
                int curr_streak = 1;
                
                while(set.contains(num+1)){
                    curr_streak++;
                    num++;
                }
                res = Math.max(res, curr_streak);
            }
        }
        return res;
    }
}