class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int dx[] = new int[]{-1, 1, 0, 0};
    int dy[] = new int[]{0, 0, -1, 1};
    
    public boolean isValid(int m, int n, int i, int j){
        return (i >= 0 && i<m && j >=0 && j<n);
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    grid[i][j] = '0';
                    q.offer(new Pair(i, j));
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        for(int k=0; k<4; k++){
                            if(isValid(m, n, p.x+dx[k], p.y+dy[k]) && grid[p.x+dx[k]][p.y+dy[k]]=='1'){
                                grid[p.x+dx[k]][p.y+dy[k]] = '0';
                                q.offer(new Pair(p.x+dx[k], p.y+dy[k]));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}