class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = prices[0];
        max[n-1] = prices[n-1];
        for( int i = 1 ; i < n ; i++){
            min[i] = Math.min( min[i-1], prices[i-1]);
        }
        for( int j = n-2; j >= 0 ; j--){
            max[j] = Math.max( max[j+1], prices[j]);
        }
        int res = 0;
        for( int i = 0; i < n; i++){
            res = Math.max(res, max[i] - min[i]);
        }
        return res;
    }
}
