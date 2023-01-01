class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(pattern.length() != arr.length) return false;
        HashMap<Character, String> map =  new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(pattern.charAt(i))){     
                if(!map.get(pattern.charAt(i)).equals(arr[i]))
                    return false;
                
            }else{
                if(!map.containsValue(arr[i])) map.put(pattern.charAt(i), arr[i]);
                else return false;
            }
        }
        return true;
    }
}