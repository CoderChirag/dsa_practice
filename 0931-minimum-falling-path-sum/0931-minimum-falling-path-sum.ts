function minFallingPathSum(matrix: number[][]): number {
    const m = matrix.length, n = matrix[0].length;
    let prevRow = new Array(n).fill(0);
    for(let i=0; i<m; i++){
        const currRow = new Array(n).fill(0);
        for(let j=0; j<n; j++){
            if(i === 0){
                currRow[j] = matrix[i][j];
                continue;
            }
            if(j > 0 && j < n-1)
                currRow[j] = matrix[i][j] + Math.min(prevRow[j], Math.min(prevRow[j-1], prevRow[j+1]));
            else if(j === 0 && j < n-1)
                currRow[j] = matrix[i][j] + Math.min(prevRow[j], prevRow[j+1]);
            else if(j > 0 && j === n-1)
                currRow[j] = matrix[i][j] + Math.min(prevRow[j], prevRow[j-1]);
            else
                currRow[j] = matrix[i][j] + prevRow[j];
        }
        prevRow = currRow;
    }
    return Math.min(...prevRow);
};