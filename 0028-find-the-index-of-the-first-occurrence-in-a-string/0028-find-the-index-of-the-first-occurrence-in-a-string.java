// Naive Solution - O((n-m+1)*m)
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length(), m = needle.length();
//         int prev = -1;
//         for(int i=0; i<n; i++){
//             int j = 0;
//             if(haystack.charAt(i+j) == needle.charAt(j)){
//                 prev = i;
//                 while(i+j < n && j < m && haystack.charAt(i+j) == needle.charAt(j) ) j++;
//                 if(j == m) return prev;
//                 else{
//                     prev = -1;
//                 }
//             }
//         }
//         return prev;
//     }
// }

// Rabin Karp Algorithm - O((n-m+1)*m) but better than Naive Solution
class Solution {
    public int strStr(String haystack, String needle) {
        int d = 256, q = 101;
        int n = haystack.length(), m = needle.length();
        if(m > n) return -1;
        int h = 1;
        for(int i=1; i<m; i++){
            h = (h*d)%q;
        }
        
        int p = 0, t = 0;
        for(int i=0; i<m; i++){
            p = (p*d + needle.charAt(i))%q;
            t = (t*d + haystack.charAt(i))%q;
        }
        
        for(int i=0; i<n-m+1; i++){
            if(p == t){
                boolean flag = true;
                for(int j=0; j<m; j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }
            if(i < n-m){
                t = (d*(t - haystack.charAt(i)*h) + haystack.charAt(i+m))%q;
                if(t < 0) t += q;
            }
        }
        return -1;
    }
}