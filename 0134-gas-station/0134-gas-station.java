class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0, curr = 0, total = 0;
        for(int i=0; i<n; i++){
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(curr < 0){
                curr = 0;
                start = i+1;
            }
        }
        if(start == n || total < 0) return -1;
        return start;
    }
}