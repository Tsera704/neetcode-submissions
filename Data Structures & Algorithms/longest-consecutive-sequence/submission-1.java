class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 1;
        int res = 1;
        int curr = 1;
        while( i < nums.length ){
            if( nums[i] == nums[i-1]){
                i++;
                continue;
            }
            else if( nums[i] == nums[i-1]+1){
                curr++;
                res = Math.max( res, curr);
            }else{
                curr = 1;
            }
            i++;
        }
        return Math.max( res, curr);
    }
}
