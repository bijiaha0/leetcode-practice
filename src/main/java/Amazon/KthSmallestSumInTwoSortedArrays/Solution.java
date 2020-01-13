package Amazon.KthSmallestSumInTwoSortedArrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i;
        if(n==0||m==0||k==0) return res;
        Queue<int[]> heap = new PriorityQueue<>((o1, o2)->o1[0]+o1[1]-o2[0]-o2[1]);
        for(i=0;i<n&&i<k;i++){
            heap.offer(new int[]{nums1[i],nums2[0],0});
        }
        while(--k >= 0 && !heap.isEmpty()){
            int[] tmp = heap.poll();
            List<Integer> tl = new ArrayList<>();
            tl.add(tmp[0]);
            tl.add(tmp[1]);
            res.add(tl);
            if(tmp[2]+1>=m) continue;
            heap.offer(new int[]{tmp[0],nums2[tmp[2]+1],tmp[2]+1});
        }
        return res;
    }
}
