class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for( int i = 0; i < n; i++){
            if( nums[i] <= 0 || nums[i] >  n ){
                nums[i] = n+1;// irrelevant;
            }// now all numbers in array aire in range 1 - n
        }
        for( int i = 0; i < n; i++){
            int num = Math.abs( nums[i] );
            if( num > n ) continue;
            num--;// 1 maps to 0 idx
            if( nums[num] > 0 ){
                nums[ num ] = -1 * nums[num];
            }
        }
        for( int i = 0; i < n; i++){
            if( nums[i] >= 0 ){
                return i+1;
            }
        }
        return n+1;
    }
}