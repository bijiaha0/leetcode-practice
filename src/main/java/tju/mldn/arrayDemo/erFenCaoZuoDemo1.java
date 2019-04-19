package tju.mldn.arrayDemo;
import java.util.Arrays;
/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:36
 * Email: clickgwas@gmail.com
 */
public class erFenCaoZuoDemo1 {
    public static void main(String[] args) throws Exception {
        int data[] = new int[] { 1, 5, 7, 2, 3, 6, 0 }; // 数组
        Arrays.sort(data); // 数组必须采用升序排序（默认）
        System.out.println(Arrays.binarySearch(data, 6));	// 二分查找
    }
}
