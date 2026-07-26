class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int matches = 0;
        if ( s1.length() > s2.length()){
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for( int i = 0; i < s1.length(); i++){
            s1count[ s1.charAt(i) - 'a']++;
            s2count[ s2.charAt(i) - 'a']++;
        }
        for( int i = 0; i < 26; i++){
            if( s1count[i] == s2count[i] ){
                matches++;
            }
        }
        if( matches == 26){
            return true;
        }
        int l = 0;
        for( int r = s1.length(); r < s2.length(); r++){
            if( matches == 26){
                return true;
            }
            int ridx = s2.charAt(r) - 'a';
            s2count[ridx]++;
            if( s1count[ridx] == s2count[ridx] ){
                matches++;
            } else if( s1count[ridx] == s2count[ridx] - 1){
                matches--;
            }

            int lidx = s2.charAt(l) - 'a';
            s2count[lidx]--;
            if( s1count[lidx] == s2count[lidx] ){
                matches++;
            }else if( s1count[lidx] == s2count[lidx] + 1){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
