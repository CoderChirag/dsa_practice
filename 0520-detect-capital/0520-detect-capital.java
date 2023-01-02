class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        for(int i=1; i<n; i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' && (word.charAt(i-1) < 'A' || word.charAt(i-1) >'Z') ) return false;
            else if(i != 1 && (word.charAt(i) < 'A' || word.charAt(i) > 'Z') && (word.charAt(i-1) >= 'A' && word.charAt(i-1) <= 'Z')) return false;
        }
        return true;
    }
}