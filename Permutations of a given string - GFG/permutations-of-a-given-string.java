//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    
    public String swap(String str, int i, int j){
        char temp;
        char[] arr = str.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
    
    public void permute(String str, int l, int r, HashSet<String> set){
        if(l == r){
            set.add(str);
            return;
        }
        for(int i=l; i<=r; i++){
            str = swap(str, l, i);
            permute(str, l+1, r, set);
            str = swap(str, l, i);
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        permute(S, 0, S.length()-1, set);
        for(String s : set) res.add(s);
        Collections.sort(res);
        return res;
    }
}