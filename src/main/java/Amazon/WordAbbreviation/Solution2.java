package Amazon.WordAbbreviation;
import java.util.HashMap;
import java.util.Map;
public class Solution2 {
    public String[] wordsAbbreviation(String[] dict) {
        String[] res = new String[dict.length];
        int round = 1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<res.length;i++){
            res[i] = abbr(dict[i],round);
            map.put(res[i],map.getOrDefault(res[i],0)+1);
        }

        while (true){
            boolean unique = true;
            round++;
            for(int i=0;i<res.length;i++){
                if(map.get(res[i])>1){
                    res[i] = abbr(dict[i],round);
                    map.put(res[i],map.getOrDefault(res[i],0)+1);
                    unique=false;
                }
            }
            if(unique){
                break;
            }
        }
        return res;
    }

    public String abbr(String s,int round){
        if(round+2>=s.length()){
            return s;
        }
        return s.substring(0,round)+(s.length()-1-round)+s.charAt(s.length()-1);
    }
}
