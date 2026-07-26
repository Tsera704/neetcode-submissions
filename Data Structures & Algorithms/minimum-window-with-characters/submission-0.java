class Solution {
    public String minWindow(String s, String t) {

        if( t.length() == 0 ){
            return "";
        }
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;

        Map<Character, Integer> tcount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for( char c : t.toCharArray()){
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }
        int need = tcount.size();
        int have = 0;
        int l = 0;
        for( int r = 0; r < s.length() ; r++){
            char ch = s.charAt(r);
            window.put( ch, window.getOrDefault(ch, 0) + 1);

            if( tcount.containsKey(ch) && tcount.get(ch) == window.get(ch) ){
                have++;
            }

            while( have == need ){

                if( (r-l+1) < resLen ){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char remove = s.charAt(l);
                window.put( remove, window.get(remove) - 1);
                if( tcount.containsKey(remove) && window.get(remove) < tcount.get(remove)){
                    have--;
                }
                l++;
            }
        }

        if( resLen == Integer.MAX_VALUE ){
            return "";
        }
        return s.substring( res[0], res[1] + 1);
    }
}
