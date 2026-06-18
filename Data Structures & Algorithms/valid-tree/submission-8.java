class Solution {
    class DSU{
        int[] parent, size;
        DSU( int n){
            parent = new int[n];
            size = new int[n];
            for( int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find( int node){
            if( parent[node] == node){
                return node;
            }
            return find( parent[node] );
        }
        public boolean union( int node1, int node2){
            int parent1 = find( node1 );
            int parent2 = find( node2 );

            if( parent1 == parent2 ){
                return false;
            }
            if( parent1 < parent2 ){
                int t = parent1;
                parent1 = parent2;
                parent2 = t;
            }
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
       DSU dsu = new DSU(n);

       for( int [] e : edges){
            if(!dsu.union( e[0], e[1])){
                return false;
            }
       }
       int p = dsu.find(0);
       for( int i = 1; i < n; i++){
            if( dsu.find(i) != p) return false;
       }
       return true;
    }
}
