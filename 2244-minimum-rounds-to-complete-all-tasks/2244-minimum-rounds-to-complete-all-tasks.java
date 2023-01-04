class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<n; i++){
            if(map.containsKey(tasks[i])){
                map.put(tasks[i], map.get(tasks[i])+1);
            }else map.put(tasks[i], 1);
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            int freq = e.getValue();
            if(freq == 1) return -1;
            if(freq%3 == 0) res += freq/3;
            else if(freq%3 == 1){
                res += ((freq-3)/3) + 2;
            }else if(freq%3 == 2){
                res += (freq/3) + 1;
            }
        }
        return res;
    }
}