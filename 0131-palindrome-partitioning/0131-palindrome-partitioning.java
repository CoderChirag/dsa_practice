// Backtracking - O(N*(2^N))
// class Solution {
    
//     private boolean isPalindrome(String s){
//         int l = 0, r = s.length()-1;
//         while(l < r){
//             if(s.charAt(l) != s.charAt(r)) return false;
//             l++;
//             r--;
//         }
//         return true;
//     }
    
//     private void backtrack(String s, int currInd, LinkedList<String> comb, List<List<String>> res){
//         if(currInd == s.length()){
//             res.add(new ArrayList<>(comb));
//             return;
//         }
        
//         for(int i=currInd; i<s.length(); i++){
//             String ss = s.substring(currInd, i+1);
//             if(isPalindrome(ss)){
//                 comb.addLast(ss);
//                 backtrack(s, i+1, comb, res);
//                 comb.removeLast();
//             }
//         }
//     }
    
//     public List<List<String>> partition(String s) {
//         List<List<String>> res = new ArrayList<>();
//         backtrack(s, 0, new LinkedList<>(), res);
//         return res;
//     }
// }


// Backtracking with DP - O(2^N)
class Solution {
    private void backtrack(String s, int currInd, LinkedList<String> comb, List<List<String>> res, boolean[][] dp){
        if(currInd == s.length()){
            res.add(new ArrayList<>(comb));
            return;
        }
        
        for(int i=currInd; i<s.length(); i++){
            String ss = s.substring(currInd, i+1);
            if((s.charAt(currInd) == s.charAt(i)) && (i-currInd <= 2 || dp[currInd+1][i-1])){
                dp[currInd][i] = true;
                comb.addLast(ss);
                backtrack(s, i+1, comb, res, dp);
                comb.removeLast();
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        boolean dp[][] = new boolean[n][n];
        backtrack(s, 0, new LinkedList<>(), res, dp);
        return res;
    }
}