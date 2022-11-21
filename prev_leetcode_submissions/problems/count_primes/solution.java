class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                res++;
                for(int j=i+i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return res;
    }
}