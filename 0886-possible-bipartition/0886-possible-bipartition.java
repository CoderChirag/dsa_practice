class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        List<Integer>[] graph=new List[n+1];  //array contains list inside it
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] v: dislikes){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }

        for(int i=1;i<=n;i++){      //iterating on color array
            if(color[i]==0){
               LinkedList<Integer> q=new LinkedList<>();
               q.add(i);
               color[i]=1;

               while(!q.isEmpty()){
                   int top=q.removeFirst();
                   for(int nbr: graph[top]){
                       if(color[nbr]==color[top]) return false;
                       if(color[nbr]==0){
                           color[nbr]=-color[top];  //as we know the neighbaour of popped() element are the ///one tho whome top element don't like/dislikelike therefore -1;  
                           q.add(nbr);
                       }
                   }
               }
            }
        }
        return true;
    }
}