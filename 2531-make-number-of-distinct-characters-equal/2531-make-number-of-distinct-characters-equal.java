class Solution {
    public boolean isItPossible(String word1, String word2) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();
        
        for(char c : word1.toCharArray()){
            mp1.put(c, mp1.getOrDefault(c, 0)+1);
        }
        for(char c : word2.toCharArray()){
            mp2.put(c, mp2.getOrDefault(c, 0)+1);
        }
        
        for(char i='a'; i<='z'; i++){
            if(!mp1.containsKey(i)) continue;
            for(char j='a'; j<='z'; j++){
                if(!mp2.containsKey(j)) continue;
                
                // Remove i & j from mp1 and mp2
                if(mp1.get(i) == 1) mp1.remove(i);
                else mp1.put(i, mp1.get(i)-1);
                if(mp2.get(j) == 1) mp2.remove(j);
                else mp2.put(j, mp2.get(j)-1);
                
                // Insert j & i to mp1 and mp2
                mp1.put(j, mp1.getOrDefault(j, 0)+1);
                mp2.put(i, mp2.getOrDefault(i, 0)+1);
                
                if(mp1.size() == mp2.size()) return true;
                
                // Remove j & i from mp1 and mp2
                if(mp1.get(j) == 1) mp1.remove(j);
                else mp1.put(j, mp1.get(j)-1);
                if(mp2.get(i) == 1) mp2.remove(i);
                else mp2.put(i, mp2.get(i)-1);
                
                // Insert i & j to mp1 and mp2
                mp1.put(i, mp1.getOrDefault(i, 0)+1);
                mp2.put(j, mp2.getOrDefault(j, 0)+1);
            }
        }
        return false;
    }
}