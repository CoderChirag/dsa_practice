class Pair implements Comparable<Pair>{
    int cap, rocks;
    Pair(int cap, int rocks){
        this.cap = cap;
        this.rocks = rocks;
    }
    
    @Override
    public int compareTo(Pair p){
        return Integer.compare(this.cap-this.rocks, p.cap-p.rocks);
    }
}

class Solution {
    public int maximumBags(int[] cap, int[] rocks, int additionalRocks) {
        ArrayList<Pair> al = new ArrayList<>();
        
        for(int i=0; i<rocks.length; i++){
            al.add(new Pair(cap[i], rocks[i]));
        }
        
        Collections.sort(al);
        
        int res = 0;
        for(int i=0; i<al.size(); i++){
            int req = al.get(i).cap - al.get(i).rocks;
            if(additionalRocks >= req){
                res++;
                additionalRocks -= req;
            }else return res;
        }
        return res;
    }
}