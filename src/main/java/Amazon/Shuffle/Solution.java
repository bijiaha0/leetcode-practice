package Amazon.Shuffle;
import java.util.Random;
/*
* http://www.gocalf.com/blog/shuffle-algo.html
* */
public class Solution {
    void shuffle(int[] arr){
        Random r =  new Random();
        for(int i=arr.length;i>=1;i--){
            swap(arr,i-1,r.nextInt(i));
        }
    }
    void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
