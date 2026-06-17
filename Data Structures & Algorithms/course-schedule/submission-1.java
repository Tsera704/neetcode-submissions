class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] ind = new int[numCourses];

        for( int i = 0; i < numCourses; i++){
            graph.add( new ArrayList<>());
        }
        for( int[] p : prerequisites){
            int c = p[0];
            int pre = p[1];
            graph.get(pre).add(c);
            ind[c]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for( int i = 0; i < numCourses; i++){
            if( ind[i] == 0){
                q.offer(i);
            }
        }
        int taken = 0;

        while( !q.isEmpty()){
            int course = q.remove();
            taken++;
            for( int nextcourse : graph.get(course) ){
                ind[nextcourse]--;
                if( ind[nextcourse] == 0){
                    q.offer(nextcourse);
                }
            }
        }
        return taken == numCourses;
    }
}
