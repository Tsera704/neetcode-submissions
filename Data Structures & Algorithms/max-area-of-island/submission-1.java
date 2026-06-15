class Solution {
    int max = 0;
    int size = 0;
    int[][] dirs = { {-1,0}, {0,-1}, {0,1}, {1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        if( grid == null || grid.length == 0) return 0;

        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++){
                if( grid[i][j] == 1 ){
                    size = 0;
                    dfs(i,j, grid);
                    max = Math.max( max, size);
                }
            }
        }

        return max;
    }
    int nr;
    int nc;
    public void dfs( int r, int c, int[][] grid){
        if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return ;
        }
        size += 1;
       
        grid[r][c] = 0;
        for( int[] dir : dirs){
            nr = r + dir[0];
            nc = c + dir[1];
            dfs(nr,nc,grid);
        }
    }
}
