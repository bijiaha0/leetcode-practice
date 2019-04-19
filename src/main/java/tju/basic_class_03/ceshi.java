package tju.basic_class_03;
/**
 * Author: bijiaha0
 * Date: 2018-10-09
 * Time: 下午8:31
 * Email: clickgwas@gmail.com
 */
public class ceshi {
    public static int minValue1(int[] p, int bag) {
        return process1( p, 0, 0, bag);
    }
    public static int process1( int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return alreadyWeight;//无效值
        }
        if (i == values.length) {
            return alreadyWeight;
        }
        return Math.min(process1(values, i + 1, alreadyWeight, bag), values[i] + process1(values, i + 1, alreadyWeight + values[i], bag));
    }
    public static void main(String[] args) {
        int[] p = { 5, 6, 3, 19,24,33,22 ,30,55};
        int bag = 44;
        System.out.println(minValue1(p,bag));
    }
}
