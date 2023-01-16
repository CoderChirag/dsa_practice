class Solution {
    
    public boolean doesIntervalsOverlap(int[] a, int[] b){
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }
    
    public int[] mergeIntervals(int[] a, int[] b){
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
    
    public int[][] insertInterval(int[][] intervals, int[] newInterval){
        
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        
        boolean flag = false;
        
        for(int i=0; i<intervals.length; i++){
            if(newInterval[0] < intervals[i][0]){
                list.add(i, newInterval);
                flag = true;
                break;
            }
        }
        
        if(!flag) list.add(newInterval);
        
        return list.toArray(new int[list.size()][2]);
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++){
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            
            while(i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])){
                currInterval = mergeIntervals(currInterval, intervals[i]);           
                i++;
            }
            
            i--;
            list.add(currInterval);
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}