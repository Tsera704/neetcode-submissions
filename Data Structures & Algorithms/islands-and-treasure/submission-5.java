class Solution {
    int rows;
    int cols;
    boolean[][] visit;
    Queue<int[]> q;

    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        q = new LinkedList<>();
        visit = new boolean[rows][cols];

        for( int i =0; i < rows; i++){
            for( int j = 0; j < cols; j++){
                if( grid[i][j] == 0 ){
                    q.offer( new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }
        int[] pos;
        int dist = 0;
        int r;
        int c;

        //now mutli sorc bfs
        while(!q.isEmpty()){
            int size = q.size();
            for( int i = 0; i < size; i++){
                pos = q.remove();
                r = pos[0];
                c = pos[1];
                grid[r][c] = dist;
                addroom(r+1, c, grid);
                addroom(r-1, c, grid);
                addroom(r, c+1, grid);
                addroom(r, c-1, grid);
            }
            dist++;
           
        }
    }
    private void addroom(int r, int c, int[][] grid){
        if( r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1 || visit[r][c] ){
            return;
        }
        visit[r][c] = true;
        q.offer( new int[]{r, c});
    }
}
