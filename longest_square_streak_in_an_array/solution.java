class Solution {
    private int MOD = 1_000_000_07;
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(nums[i]);
        
        int res = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            int a = nums[i];
            while(set.contains(a*a)){
                max++;
                a *= a;
            }
            if(max != 0) max++;
            res = Math.max(res, max);
        }
        return res == 0 ? -1 : res;
    }
}