class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[numCourses];
        int[] ans = new int[numCourses];

        for( int i =0; i < numCourses; i++){
            graph.add( new ArrayList<>());
        }
        for( int[] p : prerequisites){
            int crs = p[0];
            int pre = p[1];
            graph.get( pre ).add( crs );
            indeg[crs]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        for( int i = 0; i < numCourses; i++){
            if( indeg[i] == 0){
                q.offer(i);
            }
        }
        while( !q.isEmpty()){
            int course = q.poll();
            ans[index++] = course;
            for( int next : graph.get( course )){
                indeg[next]--;
                if( indeg[next] == 0){
                    q.offer(next);
                }
            }
        }

        if( index != numCourses){
            return new int[0];
        }
        return ans;
    }
}
