class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n];
        q.offer(0);
        while(!q.isEmpty()){
            int i = q.poll();
            if(!visited[i]){
                visited[i] = true;
                for(int j=0; j<rooms.get(i).size(); j++){
                    q.offer(rooms.get(i).get(j));
                }
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}