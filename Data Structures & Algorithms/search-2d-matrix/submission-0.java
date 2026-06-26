class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0; 
        int r = matrix.length-1;
        //to find row
        while( l <= r ){
            int mid = (r-l)/2 + l;
            if( target == matrix[mid][0]){
                return true;
            }else if( target < matrix[mid][0]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if( r < 0 ) return false;
        int row = r;

        // to find column
        int left = 0;
        int right = matrix[0].length - 1;

        // Search inside that row
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[row][mid] == target)
                return true;
            else if (target < matrix[row][mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
