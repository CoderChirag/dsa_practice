class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            if(q.size() == k){
                if(q.peek() < nums[i]){
                    q.poll();
                    q.offer(nums[i]);
                }
            }else{
                q.offer(nums[i]);
            }
        }
        
        return q.size() == k ? q.poll() : -1;
    }
}