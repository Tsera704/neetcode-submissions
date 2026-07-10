class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
       res = new ArrayList<>();
        backtrack( 0,nums,  new ArrayList<>());
        return res;
    }
    public void backtrack( int i,int[] nums, List<Integer> sub){
        if( i >= nums.length ){
            res.add( new ArrayList<>(sub));
            return;
        }
        sub.add( nums[i]);
        backtrack(i+1, nums, sub);
        sub.remove( sub.size() - 1);
        backtrack( i + 1, nums, sub);
    }
}
