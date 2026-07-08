class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while( l <= r){
            long mid = (r - l)/2 + l;
            long sq = mid * mid;
            if( sq == num){
                return true;
            }
            else if( sq < num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}