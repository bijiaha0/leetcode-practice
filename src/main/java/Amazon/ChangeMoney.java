package Amazon;

import java.util.Scanner;

public class ChangeMoney {

    public static int com(int m){
        int resu = 1024 - m;
        int count = 0;

            if(resu>=64){
                count += resu/64;
                resu = resu % 64;
            }
            if(resu>=16){
                count += resu/16;
                resu = resu % 16;
            }
            if(resu>=4){
                count += resu/4;
                resu = resu % 4;
            }
            count += resu;

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            System.out.println(com(m));
        }

    }
}
