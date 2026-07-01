class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if( (m+n) % 2 != 0 ){
            return helper( nums1, 0, nums2, 0, (m+n)/2 + 1 );
        }
        int left = helper( nums1, 0, nums2, 0, ((m+n)/2) );
        int right = helper( nums1, 0, nums2, 0 , ((m+n)/2)+ 1);

        return (left + right) / 2.0;
    }

    public int helper( int[] a, int i, int[] b, int j, int k){
        //make 1st arr to be small
        if( a.length - i > b.length - j ){
            return helper(b, j, a, i, k);
        }
        //if a is empty
        if( i == a.length ){
            return b[ j + k - 1];
        }
        if( k == 1 ){
            return Math.min(a[i], b[j]);
        }
        int half = k/2;
        int newI = Math.min( i + half, a.length );
        int newJ = Math.min( j + half, b.length );

        if( a[newI - 1] <= b[newJ - 1]){
            return helper(a, newI, b, j, k - (newI - i));
        }
        return helper(a,i, b, newJ, k - (newJ - j));
    }
}
