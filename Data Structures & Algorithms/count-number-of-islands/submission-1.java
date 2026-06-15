class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for( int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[0].length; j++)
            {
                if( grid[i][j] == '1'){
                    dfs(i,j,grid);
                    islands++;
                }
            }            
        }
        return islands;
    }
    int[][] dirs = { {-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public void dfs( int r, int c, char[][]grid){
        if( r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == '0'){
            return;
        }
        // mark it as visited;
        grid[r][c] = '0';
        for( int[] dir: dirs ){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(nr, nc, grid);
        }
    }
}
