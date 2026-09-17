class Solution {
    int[] dr = {-1, 1, 0 , 0 };
    int[] dc = {0 , 0 , 1, -1};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++){
                if( grid[i][j] == 0 ){
                    q.add( new int[]{i, j});
                }
            }
        }
        if( q.size() == 0 ){
            return;
        }
        while( !q.isEmpty() ){
            int size = q.size();
            for( int i = 0; i < size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for( int d = 0; d < 4; d++){
                    int nr = row + dr[d];
                    int nc = col + dc[d];
                    if( nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != Integer.MAX_VALUE){
                        continue;
                    }
                    grid[nr][nc] = 1 + grid[row][col];
                    q.add( new int[]{nr, nc});
                }
            }
        }
        
    }
}
