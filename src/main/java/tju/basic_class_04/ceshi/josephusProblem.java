package tju.basic_class_04.ceshi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Author: bijiaha0
 * Date: 2018-10-25
 * Time: 下午7:37
 * Email: clickgwas@gmail.com
 */
/*



* */
public class josephusProblem {
    public static void main(String[] args) {
        System.out.println("请输入围成圈的人数：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int s=0;
        for(int i=2;i<=n;i++)
        {
            s=(s+3)%i;
        }
        System.out.println(s+1);
    }
}
