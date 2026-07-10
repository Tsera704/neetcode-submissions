class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack( 0 , target, nums, new ArrayList<>());
        return res;
    }
    public void backtrack( int i, int sum, int[] nums, List<Integer> sub){
        if( sum == 0){
            res.add( new ArrayList<>(sub));
            return;
        }
        if( i >= nums.length || sum < 0){
            return;
        }
       
        sub.add(nums[i]);
        backtrack( i, sum - nums[i], nums, sub);
        sub.remove( sub.size() - 1);

        backtrack( i + 1, sum, nums, sub);
    }
}
