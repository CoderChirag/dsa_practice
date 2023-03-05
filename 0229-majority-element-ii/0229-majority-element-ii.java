class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, n1 = -1, n2 = -1, c1 = 0, c2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == n1) c1++;
            else if(nums[i] == n2) c2++;
            else if(c1 == 0){
                n1 = nums[i];
                c1 = 1;
            }else if(c2 == 0){
                n2 = nums[i];
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for(int e : nums){
            if(e == n1) c1++;
            else if(e == n2) c2++;
        }
        if(c1 > n/3) res.add(n1);
        if(c2 > n/3) res.add(n2);
        System.out.println(n1 + ": " + c1 + ", " + n2 + ": " + c2);
        return res;
    }
}