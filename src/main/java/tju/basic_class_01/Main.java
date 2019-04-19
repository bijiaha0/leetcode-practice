package tju.basic_class_01;
/**
 * Author: bijiaha0
 * Date: 2018-09-08
 * Time: 下午8:04
 * Email: clickgwas@gmail.com
 */
public class Main {
    public static void digui(char[][] chars,int x,int y){
        if(x==0||x==9||y==0||y==9){
            return;
        }
        if(chars[--x][y]=='0'){
            digui(chars,x,y);
        }
        if(chars[++x][y]=='0'){
            digui(chars,x,y);
        }
        if(chars[x][--y]=='0'){
            digui(chars,x,y);
        }
        if(chars[x][++y]=='0'){
            digui(chars,x,y);
        }
    }
    public static void main(String[] args) {
        char[][] chars = new char[10][10];
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++){
                Double value=new Double(Math.random());
                if(value >=0.5){
                    chars[i][j]='1';
                }else {
                    chars[i][j]='0';
                }
            }
        }
        int baiX = (int)Math.random() * 10;
        int baiY = (int)Math.random() * 10;
        digui(chars,baiX,baiY);
    }
}
