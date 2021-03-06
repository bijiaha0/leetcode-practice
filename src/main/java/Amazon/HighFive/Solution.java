package Amazon.HighFive;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
* https://www.jiuzhang.com/solution/high-five/
* */
class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
      }
}
public class Solution {
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> answer = new HashMap<Integer, Double>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<Integer, PriorityQueue<Integer>>();

        for (Record r : results) {
            if (!hash.containsKey(r.id)){
                hash.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq=hash.get(r.id);
            if (pq.size() < 5) {
                pq.add(r.score);
            } else {
                if (pq.peek() < r.score){
                    pq.poll();
                    pq.add(r.score);
                }
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; ++i)
                average += scores.poll();
            average /= 5.0;//double
            answer.put(id, average);
        }
        return answer;
    }
}
