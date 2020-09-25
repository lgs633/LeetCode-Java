class Solution {
	// Basic idea is: finding the left_height_max and right_height_max
	// Then min(left_height_max, right_height_max) - height[i]  ==> How much water it contains for index i
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }    
                
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        
        int sum = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                sum += maxLeft - height[left];
                maxLeft = Math.max(maxLeft, height[++left]);
            } else {
                sum += maxRight - height[right];
                maxRight = Math.max(maxRight, height[--right]);
            }
        }
        return sum;
    }
}
