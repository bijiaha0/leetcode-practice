package SuanFaNeiGong.Heap.IndexHeapAdvance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: bijiaha0
 * Date: 2019-03-10
 * Time: 17:15
 * Email: clickgwas@gmail.com
 */
public class solve {
    public static void main(String[] args) {
        String[] re = new String[3];
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        int i = 0;
        while (nextLine != null &&! nextLine.equals("")){
            re[i] = nextLine;
            nextLine = scanner.nextLine();
            i++;
            if(i == 3){
                break;
            }
        }
        int len = Integer.parseInt(re[0]);
        String[] aa = re[1].split(" ");
        String[] bb = re[2].split(" ");
        int[] a =new int[len];
        int[] b =new int[len];
        for(int ii = 0; ii < len; ii++){
            a[ii] = Integer.parseInt(aa[ii]);
            b[ii] = Integer.parseInt(bb[ii]);
        }
        ans(len,a,b);

    }
    public static int ans(int len,int[] a,int[] b) {
        Arrays.sort(a);
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(len);
        for(int i = 0; i < b.length; i++){
            indexMaxHeap.insert(i,b[i]);
        }
        int sum =0;
        for(int i = 0; i < b.length; i++){
            sum += b[indexMaxHeap.getMaxIndex()] * a[i];
            indexMaxHeap.extractMax();
        }
        return sum;
    }

}
