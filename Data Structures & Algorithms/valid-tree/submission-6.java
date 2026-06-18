class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( edges.length > n - 1){
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for( int i = 0; i < n; i++){
            graph.add( new ArrayList<>());
        }
        for( int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0,-1,visit,graph)){
            return false;
        }
        return visit.size() == n;
    }
    public boolean dfs( int node, int parent, Set<Integer> visit, List<List<Integer>> graph){
        if( visit.contains(node)){
            return false;
        }
        visit.add(node);
        for( int nei : graph.get(node) ){
            if( nei == parent){
                continue;
            }
            if(!dfs(nei, node, visit, graph)){
                return false;
            }
        }
        return true;
    }
}
