class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl  = new boolean[rows][cols];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for( int c = 0; c < cols; c++){
            pq.offer( new int[]{0,c});
            aq.offer( new int[]{rows-1, c});
        }
        for( int r = 0; r < rows; r++){
            pq.offer( new int[]{r, 0});
            aq.offer( new int[]{r, cols-1});
        }
        bfs( pq, pac, heights);
        bfs( aq, atl, heights);

        for( int i = 0; i < rows; i++){
            for( int j = 0; j < cols; j++){
                if( pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    int[][] dirs = { { -1,0}, {1,0}, {0,1}, {0,-1}};
    public void bfs( Queue<int[]> q, boolean[][] visit, int[][] hgt){
        while( !q.isEmpty()){
            int[] pos = q.remove();
            int r = pos[0];
            int c = pos[1];
            visit[r][c] = true;
            for( int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if( nr >= 0 && nr < rows && nc >=0 && nc < cols && !visit[nr][nc] && hgt[nr][nc] >= hgt[r][c] ){
                    q.offer( new int[]{nr,nc});
                }
            }
        }
    }
}
