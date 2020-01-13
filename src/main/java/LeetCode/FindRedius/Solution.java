package LeetCode.FindRedius;
import java.util.Arrays;
public class Solution {
    public int findRadius(int[] houses,int[] heater){
        Arrays.sort(heater);
        int res = Integer.MIN_VALUE;
        for(int house:houses){
            int index = Arrays.binarySearch(heater, house);
            if(index<0){
                index = -(index+1);
            }
            int left = index==0?Integer.MAX_VALUE:house-heater[index-1];
            int right = index==heater.length?Integer.MAX_VALUE:heater[index]-house;
            res = Math.max(res,Math.min(left,right));
        }
        return res;
    }
}
