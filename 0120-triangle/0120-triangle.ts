function minimumTotal(triangle: number[][]): number {
    let prevRow = new Array(triangle[triangle.length-1].length).fill(0);
    for(let i=0; i<triangle.length; i++){
        let currRow = new Array(triangle[i].length);
        for(let j=0; j<triangle[i].length; j++){
            if(i === 0 && j === 0){
                currRow[j] = triangle[i][j];
                continue;
            }
            let adj1 = Number.MAX_VALUE, adj2 = Number.MAX_VALUE;
            if(j > 0)
                adj1 = prevRow[j-1];
            if(j < i)
                adj2 = prevRow[j];
            
            currRow[j] = triangle[i][j] + Math.min(adj1, adj2);
        }
        prevRow = currRow;
    }
    
    return Math.min(...prevRow);
};