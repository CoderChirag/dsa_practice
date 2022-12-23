//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Pair p){
        if(y == p.y) return Integer.compare(x, p.x);
        
        return Integer.compare(y, p.y);
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> al = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            al.add(new Pair(start[i], end[i]));
        }
        Collections.sort(al);
        
        int res = 1, prev_end_time = al.get(0).y;
        for(int i=1; i<al.size(); i++){
            if(prev_end_time < al.get(i).x){
                res++;
                prev_end_time = al.get(i).y;
            }
        }
        return res;
    }
}
