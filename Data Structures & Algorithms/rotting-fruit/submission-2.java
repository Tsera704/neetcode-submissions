class Solution {
    int rows;
    int cols;
    Queue<int[]> q ;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        q = new LinkedList<>();
        int fresh = 0;

        for( int i = 0; i < rows; i++){
            for( int j = 0; j < cols; j++){
                if( grid[i][j] == 2){
                    q.offer( new int[]{i,j});
                }else if( grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if( fresh == 0) return 0;
        int minutes = 0;
        while( !q.isEmpty() && fresh > 0 ){
            int size = q.size();
            for( int i = 0; i < size; i++){
                int[] pos = q.remove();
                int r = pos[0];
                int c = pos[1];

                fresh -= addrotten(r+1, c, grid);
                fresh -= addrotten(r-1, c, grid);
                fresh -= addrotten(r, c+1, grid);
                fresh -= addrotten(r, c-1, grid);
            }
            minutes++;
        }

        if ( fresh != 0){
            return -1 ;
        }
        return minutes;
    }
    private int addrotten( int r, int c, int[][] grid){
        if( r <0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 2 || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 2;//mark rotten
        q.offer( new int[]{r,c});
        return 1;
    }
}
