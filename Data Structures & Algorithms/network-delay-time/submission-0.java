class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for( int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.computeIfAbsent(u, key-> new ArrayList<>()).add(new int[]{v,w});
        } 
        int[] dist = new int[n+1];
        Arrays.fill( dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        minheap.offer( new int[] {0,k});
        dist[k] = 0;

        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            int w1 = curr[0], node1 = curr[1];
            if (w1 > dist[node1])
                continue;
            
            
            //modify neighbors
            if( graph.containsKey(node1)){
                for( int[] nei : graph.get(node1)){
                    int node2 = nei[0];
                    int w2 = nei[1];
                    if( w1 + w2 < dist[node2] ){
                        dist[node2] = w1 + w2;
                        minheap.offer(new int[]{w1+w2, node2});
                    }
                }
            }
        }
        int ans = 0;
        for( int i = 1; i <= n; i++){
            if( dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max( ans, dist[i]);
        }
        return ans;
    }
}
