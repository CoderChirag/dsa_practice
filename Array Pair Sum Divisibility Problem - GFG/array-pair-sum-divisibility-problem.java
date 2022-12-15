//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int n = nums.length;
        for(int i=0; i<n; i++){
            nums[i] = nums[i]%k;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                if(map.containsKey(0) && map.get(0) > 0){
                    if(map.get(0) == 1) map.remove(0);
                    else map.put(0, map.get(0)-1);
                } else if(map.containsKey(0)) map.put(0, map.get(0)+1);
                else map.put(0, 1);
            }else{
                if(map.containsKey(k-nums[i]) && map.get(k-nums[i]) > 0){
                    if(map.get(k-nums[i]) == 1) map.remove(k-nums[i]);
                    else map.put(k-nums[i], map.get(k-nums[i])-1);
                } else if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
                else map.put(nums[i], 1);
            }
        }
        
        return map.size() == 0 ? true : false;
    }
}