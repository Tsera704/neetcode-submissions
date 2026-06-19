class Solution {
    LinkedList<String> res = new LinkedList<>();
    Map<String, PriorityQueue<String>> adj = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for( List<String> t : tickets){
            String src = t.get(0);
            String dest = t.get(1);
            adj.computeIfAbsent(src, key-> new PriorityQueue<>()).offer(dest);
        }
        dfs("JFK");
        
        return res;
    }
    void dfs( String city){
        PriorityQueue<String> pq = adj.get(city);
        while( pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next);
        }
        res.addFirst(city);
    }
}
