class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int [] rmax = new int[n];

        lmax[0] = Integer.MIN_VALUE;
        rmax[n-1] = Integer.MIN_VALUE;

        for( int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
        }
        for( int j = n-2; j >= 0 ; j--){
            rmax[j] = Math.max(rmax[j+1], height[j+1]);
        }
        int res = 0;
        for( int i = 0; i < n; i++){
            if(rmax[i] == Integer.MIN_VALUE || lmax[i] == Integer.MIN_VALUE){
                continue;
            }
            int val = ( Math.min(lmax[i], rmax[i])) - height[i];
            if( val > 0 ){
                res += val;
            }
        }
        return res;
    }
}
