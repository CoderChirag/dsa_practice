class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer>  q = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;
        for(int i=0; i<nums.length; i++){
            q.add(nums[i]);
        }
        
        for(int i=0; i<k; i++){
            int n = q.poll();
            score += n;
            n = (int)Math.ceil(n/3.0);
            q.add(n);
        }
        return score;
    }
}