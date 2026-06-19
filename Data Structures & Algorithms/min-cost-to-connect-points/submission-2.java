class Solution {
    class DSU{
        int[] parent, size;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for( int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find( int x ){
            if( parent[x] != x){
                parent[x] = find( parent[x] );
            }
            return parent[x];
        }
        public boolean union( int a, int b){
            int pa = find(a);
            int pb = find(b);
            if( pa == pb) return false;
            if( size[pa] < size[pb] ){
                int tmp = pa;
                pa = pb;
                pb = tmp;
            }
            parent[pb] = pa;
            size[pa] += size[pb];
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        DSU dsu = new DSU(n);

        for( int i = 0; i < n; i++){
            for( int j = i+1; j < n; j++){
                int dist = Math.abs( points[i][0] - points[j][0]) + 
                            Math.abs( points[i][1] - points[j][1]);
                edges.add( new int[]{dist, i, j });
            }
        }
        int res = 0;
        edges.sort( (a, b) -> Integer.compare(a[0], b[0]));
        for( int[] ed : edges){
            if( dsu.union( ed[1], ed[2])){
                res += ed[0];
            }
        }
        return res;
    }
}
