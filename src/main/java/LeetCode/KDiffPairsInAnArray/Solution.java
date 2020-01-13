package LeetCode.KDiffPairsInAnArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public  int findPairs(int[] arr, int target){
        int count =0;
        if(arr==null||arr.length<1){
            return count;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tmp: arr){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(target!=0){
                if(map.containsKey(entry.getKey()-target)){
                    count++;
                }
            }else {
                if(entry.getValue()>1){
                    count++;
                }
            }
        }
        return count;
    }
}
