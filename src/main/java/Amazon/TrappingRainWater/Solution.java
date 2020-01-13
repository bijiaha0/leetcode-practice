package Amazon.TrappingRainWater;
public class Solution {
    public int trap(int[] heights) {
        if ( heights.length <= 2 ) { return 0; }
        int left = 0, right = heights.length-1, totalArea = 0;
        int leftMaxHeight = heights[left], rightMaxHeight = heights[right];
        while ( left < right ) {
            if ( heights[left] < heights[right] ) {
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, heights[left]);
                totalArea += leftMaxHeight-heights[left];
            } else {
                right--;
                rightMaxHeight = Math.max(rightMaxHeight, heights[right]);
                totalArea += rightMaxHeight-heights[right];
            }
        }
        return totalArea;
    }
}
