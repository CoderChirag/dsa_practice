class Solution {
public:
    int countPrimes(int n) {
        int cnt = 0;
        vector<int> isPrime(n+1, true);
        for(int i=2; i*i<n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(isPrime[i]) cnt++;
        }
        return cnt;
    }
};