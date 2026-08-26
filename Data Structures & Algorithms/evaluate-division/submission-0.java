class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> adj = new HashMap<>();
        for( int i = 0; i < values.length; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent( b, new ArrayList<>());
            adj.get(a).add( new Pair(b, v));
            adj.get(b).add( new Pair(a, 1/v));
        }
        double[] res = new double[queries.size()];
        for( int i = 0; i < queries.size(); i++){
            String sc = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            res[i] = bfs(sc, target, adj);
        }
        return res;
    }
    public double bfs( String s, String t, HashMap<String, List<Pair>> adj){
        if (!adj.containsKey(s) || !adj.containsKey(t)) {
            return -1.0;
        }
        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer( new Pair(s, 1.0) );
        visited.add(s);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String n = curr.node;
            double w = curr.wgt;
            if( n.equals(t)){
                return w;
            }
            for( Pair nei: adj.get(n)){
                if( !visited.contains(nei.node)){
                    visited.add(nei.node);
                    q.offer( new Pair(nei.node, w* nei.wgt));
                }
            }
        }
        return -1.0;
    }
    class Pair{
        String node;
        double wgt;
        Pair( String n, double wgt){
            this.node = n;
            this.wgt = wgt;
        }
    }
}