class Solution {
    private int BASE = 256, MOD = 101; // BASE = d, MOD = q
    
    public boolean rabin_karp(String a, String b){
        int n = a.length(), m = b.length();
        if(n < m) return false;
        int pow = 1; // pow = h, i.e, (d^(m-1))%q
        for(int i=1; i<m; i++){
            pow = (pow*BASE)%MOD;
        }
        
        int pattern_hash = 0, text_hash = 0;
        for(int i=0; i<m; i++){
            pattern_hash = (pattern_hash*BASE + b.charAt(i))%MOD;
            text_hash = (text_hash*BASE + a.charAt(i))%MOD;
        }
        
        for(int i=0; i<n-m+1; i++){
            if(text_hash == pattern_hash && a.substring(i, i+m).equals(b)) return true;
            
            if(i < n-m){
                text_hash = (BASE*(text_hash - a.charAt(i)*pow) + a.charAt(i+m))%MOD;
                if(text_hash < 0) text_hash += MOD;
            }
        }
        return false;
    }
    
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int res = 1;
        String str = a;
        while(str.length() < b.length()){
            res++;
            str = str+a;
        }
        if(rabin_karp(str, b)) return res;
        if(rabin_karp(str+a, b))  return res+1;
        return -1;
    }
}