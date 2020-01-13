package LeetCode.NumberOfLand;
public class Solution {
    public int num(char[][] matriax){
        int count = 0;
        if(matriax==null||matriax.length==0||matriax[0]==null||matriax[0].length==0){
            return count;
        }
        for(int i = 0; i < matriax.length;i++){
            for(int j = 0; j < matriax[0].length;j++){
                if(matriax[i][j]=='1'){
                    count++;
                    helper(matriax,i,j);
                }
            }
        }
        return count;
    }
    public void helper(char[][] matriax,int i, int j){
        if(i-1<0||i+1>=matriax.length||j-1<0||j+1>=matriax[0].length||matriax[i][j]=='0'){
            return;
        }
        matriax[i][j]='0';
        helper(matriax,i-1,j);
        helper(matriax,i+1,j);
        helper(matriax,i,j-1);
        helper(matriax,i,j+1);
    }
}

