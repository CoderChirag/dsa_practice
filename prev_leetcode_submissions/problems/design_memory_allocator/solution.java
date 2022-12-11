// Brute Force
// class Allocator {
//     int mem[];
//     public Allocator(int n) {
//         mem = new int[n];
//     }
    
//     public int allocate(int size, int mID) {
//         int cnt = 0;
//         for(int i=0; i<mem.length; i++){
//             if(mem[i] == 0){
//                 if(++cnt == size){
                    
//                     for(int j=0; j<size; j++){
//                         mem[j+(i-size+1)] = mID;
//                     }
//                     return i-size+1;
//                 }
//             }else cnt = 0;
//         }
//         return -1;
//     }
    
//     public int free(int mID) {
//         int res = 0;
//         for(int i=0; i<mem.length; i++){
//             if(mem[i] == mID){
//                 res++;
//                 mem[i] = 0;
//             }
//         }
//         return res;
//     }
// }

class Allocator {
    HashMap<Integer, TreeMap<Integer, Integer>> mem = new HashMap<>();
    public Allocator(int n) {
        TreeMap<Integer, Integer> ranges = new TreeMap<>();
        ranges.put(0, n-1); // address start from 0
        mem.put(0, ranges); // 0 means free block
    }
    
    public int allocate(int size, int mID) {
        int addr = -1;
        int availRange[] = new int[]{-1, -1};
        for(Map.Entry<Integer, Integer> range : mem.get(0).entrySet()){
            int startAdd = range.getKey(), endAdd = range.getValue();
            if(endAdd-startAdd+1 >= size){
                addr = startAdd;
                availRange[0] = startAdd;
                availRange[1] = endAdd;
                break;
            }
        }
        
        if(addr != -1){
            mem.computeIfAbsent(mID, x -> new TreeMap<>()).put(availRange[0], availRange[0]+size-1);
            mem.get(0).remove(availRange[0]);
            if(availRange[1] > availRange[0]+size-1) mem.get(0).put(availRange[0]+size, availRange[1]);
        }
        
        mergeRanges(mID);
        return addr;
    }
    
    public int free(int mID) {
        int cnt = 0;
        TreeMap<Integer, Integer> freeRanges = mem.get(mID);
        
        if(freeRanges != null){
            for(Map.Entry<Integer, Integer> range : freeRanges.entrySet()){
                int startAdd = range.getKey(), endAdd = range.getValue();
                cnt += endAdd-startAdd+1;
                mem.get(0).put(startAdd, endAdd);
            }
        }
        
        mem.remove(mID);
        mergeRanges(0);
        return cnt;
    }
    
    public void mergeRanges(int mID){
        TreeMap<Integer, Integer> curRanges = mem.get(mID);
        TreeMap<Integer, Integer> mergedRanges = new TreeMap<>();
        
        int lastRange[] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        if(curRanges != null){
            for(Map.Entry<Integer, Integer> range : curRanges.entrySet()){
                int startAdd = range.getKey(), endAdd = range.getValue();
                if(startAdd - 1 == lastRange[1]){
                    lastRange[1] = endAdd;
                }else{
                    if(lastRange[0] != Integer.MIN_VALUE) mergedRanges.put(lastRange[0], lastRange[1]);
                    lastRange[0] = startAdd;
                    lastRange[1] = endAdd;
                }
            }
        }
        if(lastRange[0] != Integer.MIN_VALUE) mergedRanges.put(lastRange[0], lastRange[1]);
        
        mem.put(mID, mergedRanges);
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */