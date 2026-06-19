class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        HashSet<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visit.add(beginWord);

        int steps = 1;
        while(!q.isEmpty()){
            int level = q.size();
            for( int i = 0; i < level; i++){
                String curr = q.poll();
                if( curr.equals(endWord)){
                    return steps;
                }
                char[] arr = curr.toCharArray();
                for( int j = 0; j < arr.length; j++){
                    char og = arr[j];
                    for( char c = 'a'; c <= 'z'; c++){
                        if( c == og) continue;
                        arr[j] = c;
                        String newwrd = new String(arr);
                        if( dict.contains(newwrd) && !visit.contains(newwrd)){
                            q.offer(newwrd);
                            visit.add(newwrd);
                        }
                    }
                    arr[j] = og;
                }
            }
            steps++;
        }
        return 0;
    }
}
