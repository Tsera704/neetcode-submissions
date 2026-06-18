class Solution {
   
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        HashSet<Integer> visit = new HashSet<>();

        if( edges.length > n - 1){
            return false;
        }
        for( int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for( int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});
        visit.add(0);

        while(!q.isEmpty()){
            int[] edge = q.poll();
            int node = edge[0];
            int parent = edge[1];
            for( int nei : graph.get(node)){
                if( nei == parent ) {
                    continue;
                }
                if( visit.contains(nei) ){
                    return false;
                }
                visit.add(nei);
                q.offer( new int[]{nei,node});
            }
        }
        return visit.size() == n;
    }
}
