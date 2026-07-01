class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int n = piles.length;
        int ans = piles[n-1];
        int l = 1;
        int r = piles[n-1];
        while( l <= r ){
            int mid = (r-l)/2 + l;

            int hrs = helper(piles, mid);

            if( hrs <= h  ){
                ans = Math.min( ans, mid);
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public int helper( int[] piles, int idx ){
        int k = idx;
        int res = 0;
        for( int n : piles){
            res += (n + k - 1) / k;
        }
        return res;
    }
}
