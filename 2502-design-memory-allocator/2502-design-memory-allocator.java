class Allocator {
    int mem[];
    public Allocator(int n) {
        mem = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int cnt = 0;
        for(int i=0; i<mem.length; i++){
            if(mem[i] == 0){
                if(++cnt == size){
                    
                    for(int j=0; j<size; j++){
                        mem[j+(i-size+1)] = mID;
                    }
                    return i-size+1;
                }
            }else cnt = 0;
        }
        return -1;
    }
    
    public int free(int mID) {
        int res = 0;
        for(int i=0; i<mem.length; i++){
            if(mem[i] == mID){
                res++;
                mem[i] = 0;
            }
        }
        return res;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */