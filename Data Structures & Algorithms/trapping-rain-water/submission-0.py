class Solution:
    def trap(self, height: List[int]) -> int:
        if not  height:
            return 0

        l = 0
        res = 0
        r = len(height) - 1
        lmax, rmax = height[l], height[r]

        while l < r :
            if lmax <= rmax :
                l += 1
                if lmax - height[l] > 0:
                    res += (lmax - height[l])
                lmax = max( lmax, height[l])

            else:
                r -= 1
                if rmax - height[r] > 0:
                    res += ( rmax - height[r])
                rmax = max(rmax, height[r])
        
        return res
