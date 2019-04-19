package WanZhuanShuJuJieGou;
/**
 * Author: bijiaha0
 * Date: 2018-12-03
 * Time: 9:41 AM
 * Email: clickgwas@gmail.com
 */

public class arraySort {

    //冒泡排序，a 表示数组 n 表示数组大小
    public void bubbleSort(int[] arr,int n){

        if(n < 1){
            return;
        }

        for(int i = 0; i < n; ++i){
            //提前退出冒泡排序的标志位
            boolean flag = false;
            for(int j = 0; j < n-i-1; ++j){
                if(arr[j] > arr[j+1]){//交换
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = true;//表示有数据交换
                }
            }
            if(!flag){//没有数据交换，提前退出
                break;
            }
        }

    }
}
