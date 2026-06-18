class Solution {
    class DSU{
        int[] parent, size;
        DSU( int n){
            parent = new int[n];
            size = new int[n];
            for( int i = 0; i < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find( int x){
            if( parent[x] == x){
                return x;
            }
            return parent[x] = find( parent[x]);
        }
        public boolean union( int a, int b){
            int pa = find( a );
            int pb = find( b );
            if( pa == pb ) return false;
            if( size[pa] < size[pb] ){
                int tmp = pa;
                pa = pb;// bigger one
                pb = tmp;
            }
            parent[pb] = pa;
            size[pa] += size[pb];
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu =  new DSU(n);
        int components = n;
        for( int[] e : edges ){
            if( dsu.union(e[0], e[1])){
               components--;
            }            
        }
        return components;
    }
}
