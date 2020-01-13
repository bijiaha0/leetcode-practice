package Amazon.ContainerWithMostWater;
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1,res = Integer.MIN_VALUE;
        while(left<right){
            res = Math.max(res,Math.min(height[right],height[left])*(right-left));
            if(height[left]<height[right]) {
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
