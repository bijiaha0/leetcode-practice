package tju.mldn.stringDemo;

/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午5:21
 * Email: clickgwas@gmail.com
 */
public class ziMuZhuanDaXie {
    public static void main(String args[]) {
        String str = "helloworld" ;
        char [] result = str.toCharArray() ; // 将字符串变为字符数组
        for (int x = 0 ;x < result.length ; x ++) {
            result[x] -= 32 ;	// 编码减少32
        }
        // 将处理后的字符数组交给String变为字符串
        String newStr = new String(result) ;
        System.out.println(newStr) ;
        System.out.println(new String(result,0,5)) ;
    }
}
