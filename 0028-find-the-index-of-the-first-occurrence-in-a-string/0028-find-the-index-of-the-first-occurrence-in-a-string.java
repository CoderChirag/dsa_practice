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
// Naive Solution 2 -> O((n-m+1)*m)
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length(), m = needle.length();
//         for(int i=0; i<n-m+1; i++){
//             if(haystack.substring(i, i+m).equals(needle)) return i;
//         }
//         return -1;
//     }
// }

// Rabin Karp Algorithm - O((n-m+1)*m) but better than Naive Solution
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int d = 256, q = 101;
//         int n = haystack.length(), m = needle.length();
//         if(m > n) return -1;
//         int h = 1;
//         for(int i=1; i<m; i++){
//             h = (h*d)%q;
//         }
        
//         int p = 0, t = 0;
//         for(int i=0; i<m; i++){
//             p = (p*d + needle.charAt(i))%q;
//             t = (t*d + haystack.charAt(i))%q;
//         }
        
//         for(int i=0; i<n-m+1; i++){
//             if(p == t){
//                 boolean flag = true;
//                 for(int j=0; j<m; j++){
//                     if(haystack.charAt(i+j) != needle.charAt(j)){
//                         flag = false;
//                         break;
//                     }
//                 }
//                 if(flag) return i;
//             }
//             if(i < n-m){
//                 t = (d*(t - haystack.charAt(i)*h) + haystack.charAt(i+m))%q;
//                 if(t < 0) t += q;
//             }
//         }
//         return -1;
//     }
// }

// KMP Algorithm - O(n+m) By creating a Longest Proper Prefix Sufix Length array of the pattern (string needle here) - LPS[i] = Length of the longest proper prefix which is also suffix of the string upto ith index. 
// class Solution {
//     public void fillLPSArray(String str, int LPS[]){
//         int n = str.length();
//         LPS[0] = 0;
//         int i = 1, prevLPSLen = 0;
//         while(i < n){
//             if(str.charAt(i) == str.charAt(prevLPSLen)) LPS[i++] = ++prevLPSLen;
//             else{
//                 if(prevLPSLen == 0) LPS[i++] = 0;
//                 else prevLPSLen = LPS[prevLPSLen-1];
//             }
//         }
//     }
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length(), m = needle.length();
//         int LPS[] = new int[m];
//         fillLPSArray(needle, LPS);
//         int i = 0, j = 0;
//         while(i < n){
//             if(haystack.charAt(i) == needle.charAt(j)){
//                 i++;
//                 j++;
//             }
//             if(j == m) return i-m;
//             else if(i<n && needle.charAt(j) != haystack.charAt(i)){
//                 if(j == 0) i++;
//                 else j = LPS[j-1];
//             }
//         }
//         return -1;
//     }
// }

// Z Algorithm - O(n+m) By creating Z array - 
// class Solution {
//     public void fillZArray(String s, int Z[]){
//         int n = s.length();
//         Z[0] = 0;
//         int l = 0, r = 0;
//         for(int i=1; i<n; i++){
//             if(i > r){
//                 l = r = i;
//                 while(r < n && s.charAt(r-l) == s.charAt(r)) r++;
//                 Z[i] = r-l;
//                 r--;
//             }else{
//                 int k = i-l;
//                 if(Z[k] < r-i+1) Z[i] = Z[k];
//                 else{
//                     l = i;
//                     while(r < n && s.charAt(r-l) == s.charAt(r)) r++;
//                     Z[i] = r-l;
//                     r--;
//                 }
//             }
//         }
//     }
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length(), m = needle.length();
//         String s = needle + "_" + haystack;
//         int l = s.length();
//         int Z[] = new int[l];
//         fillZArray(s, Z);
//         for(int i=0; i<l; i++){
//             System.out.print(Z[i] + " ");
//             if(Z[i] == m) return i-m-1;
//         }
//         return -1;
//     }
// }


class Solution {
    private int BASE = 256, MOD = 101; // BASE = d, MOD = q
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m > n) return -1;
        int pow = 1; // pow = h, ie, ((d^(m-1))%q)
        for(int i=1; i<m; i++){
            pow = (pow*BASE)%MOD;     // Calculating (d^(m-1))%q
        }
        
        int pattern_hash = 0, text_hash = 0;
        for(int i=0; i<m; i++){
            pattern_hash = (pattern_hash*BASE + needle.charAt(i))%MOD;
            text_hash = (text_hash*BASE + haystack.charAt(i))%MOD;
        }
        
        for(int i=0; i<n-m+1; i++){
            if(text_hash == pattern_hash && haystack.substring(i, i+m).equals(needle)) return i; // Check for hash match & spurious hit
            if(i < n-m){ // Every time we calculate paatern hash for the (i+1)th window, and we don't have any (n-m+1)th window.
                text_hash = (BASE*(text_hash - pow*haystack.charAt(i)) + haystack.charAt(i+m))%MOD;
                if(text_hash < 0) text_hash += MOD;
            }
        }
        return -1;
        
    }
}