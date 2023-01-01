class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean isPrime[] = new boolean[right+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i<=right; i++){
            if(isPrime[i] && i >= left) al.add(i);
            long k = i*i;
            if(k >= 0 && k<= right){
                for(int j=i*i; j<=right; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        if(al.size() < 2) return new int[]{-1,-1};
        int res = Integer.MAX_VALUE, x = -1, y = -1;
        for(int i=0; i<al.size()-1; i++){
            if(al.get(i+1)-al.get(i) < res){
                res = al.get(i+1)-al.get(i);
                x = al.get(i);
                y = al.get(i+1);
            }
        }
        return new int[]{x,y};
    }
}