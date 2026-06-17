class Solution {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for( int r = 0; r < rows; r++ ){
            if( board[r][0] == 'O' ){
                board[r][0] = 'T';
                q.offer( new int[]{r,0});
            }
            if( board[r][cols-1] == 'O'){
                board[r][cols-1] = 'T';
                q.offer( new int[]{r, cols-1});
            }
        }
        for( int c = 0; c < cols; c++){
            if( board[0][c] == 'O'){
                board[0][c] = 'T';
                q.offer( new int[]{0,c});
            }
            if( board[rows-1][c] == 'O'){
                board[rows-1][c] = 'T';
                q.offer( new int[]{rows-1, c});
            }
        }
        bfs(q, board);

        for( int i = 0; i < rows; i++){
            for( int j = 0; j < cols; j++){
                if( board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if( board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    int[][] dirs = { {-1,0}, {1,0}, {0,1}, {0,-1}};
    public void bfs( Queue<int[]> q, char[][] board){
        while( !q.isEmpty()){
            int[] pos = q.remove();
            int r = pos[0];
            int c = pos[1];
            
            for( int[] d: dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if( nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'O'){
                    q.offer( new int[]{nr,nc});
                    board[nr][nc] = 'T';
                }
            }
        }
    }
}
