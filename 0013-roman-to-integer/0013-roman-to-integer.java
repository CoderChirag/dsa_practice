class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        
        for(int i=0; i<s.length()-1; i++){
            int curr = map.get(s.charAt(i)), next = map.get(s.charAt(i+1));
            if(next <= curr ){
                num += curr;
            }else{
                num -= curr;
            }
        }
        
        num += map.get(s.charAt(s.length()-1));
        return num;
        
    }
}