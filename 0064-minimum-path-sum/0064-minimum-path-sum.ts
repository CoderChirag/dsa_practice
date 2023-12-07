function minPathSum(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    
    let prevRow = new Array(n).fill(0);
    for(let i=0; i<m; i++){
        let currRow = new Array(n).fill(0);
        for(let j=0; j<n; j++){
            let up = -1, left = -1;
            if(i > 0)
                up = prevRow[j];
            if(j > 0)
                left = currRow[j-1];
            
            currRow[j] = grid[i][j] + ((up === -1 && left === -1) ? 0 : up === -1 ?  left : left === -1 ? up : Math.min(up, left));
                
        }
        prevRow = currRow;
    }
    return prevRow[n-1];
};