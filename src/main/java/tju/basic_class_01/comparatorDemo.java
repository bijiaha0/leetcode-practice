package tju.basic_class_01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * Email: clickgwas@gmail.com
 */
public class comparatorDemo {
    public static class Meet {
        public int s;
        public int f;
        public Meet(int start, int end) {
            this.s = start;
            this.f= end;
        }
    }
    public static class MeetComparator implements Comparator<Meet> {
        @Override
        public int compare(Meet o1, Meet o2) {
            if((o1.f-o1.s)!=(o2.f-o2.s)){
                if((o1.f-o1.s)>(o2.f-o2.s)){
                    return -1;
                }else if((o1.f-o1.s)<(o2.f-o2.s)){
                    return 1;
                }
            }else {
                if(o1.s<o2.s){
                    return -1;
                }else if(o1.s>o2.s){
                    return 1;
                }
            }
            return 0;
        }
    }
    public static void printMeets(Meet[] meets) {
        for (Meet met: meets) {
            System.out.println(met.s + ", " + met.f);
        }
    }
    public static void main(String[] args) {
        Meet meet1=new Meet(8,10);
        Meet meet2=new Meet(9,11);
        Meet meet3= new Meet(13,15);
        Meet meet4=new Meet(0,0);
        Meet[] meets = {meet1,meet2,meet3,meet4};
        List<Meet> meet=new ArrayList<>();
        for(int i=0;i<meets.length;i++){
            if((meets[i].s >= 9) && (meets[i].f < 21)){
                meet.add(meets[i]);
            }
        }
        Meet[] meetFinal= new Meet[meet.size()];
        for(int j=0;j<meet.size();j++){
            meetFinal[j]=meet.get(j);
        }
        printMeets(meetFinal);
    }
}