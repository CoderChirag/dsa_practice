class Solution {
    
    private void backtrack(LinkedList<Integer> comb,
                           int target, int currIndex,
                           List<int[]> freqList,
                           List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;

        }

        for (int i = currIndex; i < freqList.size(); i++) {
            int[] entry = freqList.get(i);
            int cand = entry[0], freq = entry[1];

            if (freq > 0 && target >= cand){
                comb.addLast(cand);
                freqList.set(i, new int[]{cand, freq - 1});
                backtrack(comb, target - cand, i, freqList, res);
                freqList.set(i, new int[]{cand, freq});
                comb.removeLast();
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int cand : candidates) {
            if (freqMap.containsKey(cand))
                freqMap.put(cand, freqMap.get(cand) + 1);
            else
                freqMap.put(cand, 1);
        }

        // convert the counter table to a list of (num, count) tuples
        List<int[]> freqList = new ArrayList<>();
        freqMap.forEach((key, value) -> {
            freqList.add(new int[]{key, value});
        });

        backtrack(new LinkedList<>(), target, 0, freqList, res);
        return res;
    }
}