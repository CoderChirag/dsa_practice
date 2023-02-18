class Solution {
    public int minMaxDifference(int num) {
        String n = Integer.toString(num);
        String minVal = "", maxVal = "";
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) != '9'){
                maxVal += n.charAt(i);
                break;
            }
        }
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) != '0'){
                minVal += n.charAt(i);
                break;
            }
        }
        int max = 0, min = 0;
        if(maxVal == "") maxVal = "9";
        if(minVal == "") minVal = "0";
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) == maxVal.charAt(0)){
                max += Math.pow(10, n.length()-i-1)*9;
            }else{
                max += Math.pow(10, n.length()-i-1)*(n.charAt(i) - '0');
            }
            
            if(n.charAt(i) == minVal.charAt(0)){
                min += Math.pow(10, n.length()-i-1)*0;
            }else{
                min += Math.pow(10, n.length()-i-1)*(n.charAt(i) - '0');
            }

        }
        return max - min;
    }
}