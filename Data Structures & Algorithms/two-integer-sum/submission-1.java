class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];

        for( int i = 0; i < nums.length; i++){
            int temp = target - nums[i];

            if( map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
                
            }

            map.put(nums[i],i);
        }

        return res;
    }
}
