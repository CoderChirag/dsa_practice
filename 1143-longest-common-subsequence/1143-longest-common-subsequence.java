// Recursive Solution - Time Limit Exceeded

// class Solution { 
//     public int lcs(String t1, String t2){
//         if(t1.length() == 0 || t2.length() == 0) return 0;
//         if(t1.charAt(0) == t2.charAt(0)) return 1 + lcs(t1.substring(1, t1.length()), t2.substring(1, t2.length()));
        
//         return Math.max(lcs(t1.substring(1, t1.length()), t2), lcs(t1, t2.substring(1, t2.length())));
//     }
    
//     public int longestCommonSubsequence(String text1, String text2) {
//         return lcs(text1, text2);
//     }
// }


// DP - Tabular Form
class Solution {     
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}