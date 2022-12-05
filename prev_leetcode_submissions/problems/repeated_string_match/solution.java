class Solution {
    public boolean rabinKarp(String s, String pat){
        int q = 101, d = 256;
        int n = s.length(), m = pat.length();
        int h = 1;
        for(int i=1; i<m; i++) h = (h*d)%q;
        
        int p = 0, t = 0;
        for(int i=0; i<m; i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + s.charAt(i))%q;
        }
        
        for(int i=0; i<n-m+1; i++){
            if(p == t){
                boolean flag = true;
                for(int j=0; j<m; j++){
                    if(s.charAt(i+j) != pat.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) return true;
            }
            if(i < n-m){
                t = (d*(t - s.charAt(i)*h) + s.charAt(i+m))%q;
                if(t < 0) t += q;
            }
        }
        return false;
    }
    
    public int repeatedStringMatch(String a, String b) {
        if(a == b) return 1;
        int count = 1;
        String source = a;
        while(source.length() < b.length()){
            count++;
            source += a;
        }
        if(a == b) return count;
        if(rabinKarp(source, b)) return count;
        if(rabinKarp(source+a, b)) return count+1;
        return -1;
    }
}