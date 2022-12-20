class Solution {
public:
    int isValid(vector<vector<int>>& grid, int x, int y){
        return (x >= 0) && (x < grid.size()) && (y >= 0) && (y < grid[0].size()) && grid[x][y] == 1;
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        int total = 0, count = 0, time = 0;
        queue<pair<int, int>> q;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]) total++;
                if(grid[i][j] == 2){
                    q.push({i, j});
                }
            }
        }
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        while(!q.empty()){
            int k = q.size();
            count += k;
            while(k--){
                int x = q.front().first, y = q.front().second;
                q.pop();
                for(int i=0; i<4; i++){
                    int nx = x+dx[i], ny = y+dy[i];
                    if(isValid(grid, nx, ny)){
                        grid[nx][ny] = 2;
                        q.push({nx, ny});
                    }
                }
            }
            if(!q.empty()){
                time++;
            };
        }
        return count == total ? time : -1;
    }
};