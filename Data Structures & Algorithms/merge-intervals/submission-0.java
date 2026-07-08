class Solution {
    public int[][] merge(int[][] intervals) {
        if( intervals.length == 0 || intervals == null){
            return intervals;
        }
        Arrays.sort( intervals, (a, b) -> Integer.compare( a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = new int[2];
        curr[0] = intervals[0][0];
        curr[1] = intervals[0][1];

        int i = 1;
        while( i < intervals.length ){
            
            if( intervals[i][0] <= curr[1]){
                curr[1] = Math.max( curr[1], intervals[i][1]);
            }else{
                res.add(curr);
                curr = intervals[i];
            }
            i++;
        }
         res.add(curr);
        return res.toArray( new int[res.size()][]);
    }
}
