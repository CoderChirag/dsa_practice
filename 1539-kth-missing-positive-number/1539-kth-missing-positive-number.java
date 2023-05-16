class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        int cnt = 0;
        for(int i=1; i<=1_000_000_000; i++){
            if(!set.contains(i)) cnt++;
            if(cnt == k) return i;
        }
        return -1;
    }
}