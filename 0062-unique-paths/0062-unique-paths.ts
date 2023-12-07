// function rec(i: number, j: number, m: number, n: number){
//     if(i === 0 && j === 0) return 1;
//     let up = 0;
//     let left = 0;
//     if(i > 0)
//         up = rec(i-1, j, m, n);
//     if(j > 0)
//         left = rec(i, j-1, m, n);
//     return up + left;
// }

function uniquePaths(m: number, n: number): number {
    let prevRow = new Array(n).fill(0);
    for(let i=0; i<m; i++){
        let currRow = new Array(n).fill(0);
        for(let j=0; j<n; j++){
            if(i === 0 && j === 0){
                currRow[j] = 1;
                continue;
            }
            let up = 0, left = 0;
            if(i > 0)
                up = prevRow[j];
            if(j > 0)
                left = currRow[j-1];
            currRow[j] = up + left;
        }
        prevRow = currRow;
    }
    return prevRow[n-1];
};