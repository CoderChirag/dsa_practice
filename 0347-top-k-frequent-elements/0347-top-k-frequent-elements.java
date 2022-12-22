class Solution {
    class Pair implements Comparable<Pair>{
        int key, freq;
        Pair(int key, int freq){
            this.key = key;
            this.freq = freq;
        }
        
        @Override public int compareTo(Pair p){
            return Integer.compare(freq, p.freq);
        }
    }
        
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else map.put(nums[i], 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(q.size() == k){
                if(q.peek().freq < entry.getValue()){
                    q.poll();
                    q.offer(new Pair(entry.getKey(), entry.getValue()));
                }
            }else{
                q.offer(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        while(!q.isEmpty()){
            al.add(q.poll().key);
        }
        int arr[] = new int[al.size()];
        for(int i=0; i<al.size(); i++) arr[i] = al.get(i);
        return arr;
    }
}