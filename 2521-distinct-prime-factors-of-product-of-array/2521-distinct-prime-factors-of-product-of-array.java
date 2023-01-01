class Solution {
    int MOD = 1_00_00_00_007;
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 1) continue;
            if(nums[i] % 2 == 0) set.add(2);
            while(nums[i] %2 == 0){
                nums[i] /= 2;
            }
            if(nums[i] % 3 == 0) set.add(3);
            while(nums[i] % 3 == 0) nums[i] /= 3;
            for(int j=5; j*j<=nums[i]; j+=6){
                if(nums[i] % j == 0) set.add(j);
                if(nums[i]%(j+2) == 0) set.add(j+2);
                while(nums[i]%j == 0) nums[i]/=j;
                while(nums[i]%(j+2) == 0) nums[i]/=(j+2);
            }
            if(nums[i] > 3) set.add(nums[i]);
        }
        return set.size();
    }
}