class Solution {
    class DSU{
        int[] parent, size;
        DSU( int n ){
            parent = new int[n];
            size = new int[n];
            for( int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find( int x){
            if( parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return  parent[x];
        }
        public boolean union( int a, int b){
            int pa = find( a );
            int pb = find( b );
            if( pa == pb ) return false;//cycle exist
            if( size[pa] < size[pb] ){
                int tmp = pa;
                pa = pb;
                pb = tmp;
            } 
            parent[pb] = pa;
            size[pa] += size[pb];
            return true;// no cycle
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n+1);

        for( int[] e : edges){
            if( !dsu.union(e[0], e[1])){
                return e;
            }
        }
        return new int[0];
    }
}
