class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int cmax = nums[0];
        int cmin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int prevMax = cmax;
            int prevMin = cmin;

            cmax = Math.max(num,
                    Math.max(num * prevMax, num * prevMin));

            cmin = Math.min(num,
                    Math.min(num * prevMax, num * prevMin));

            res = Math.max(res, cmax);
        }
        return res;
    }
}
