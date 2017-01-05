import java.util.*;

public class LC362_DesignHitCounter {
    HashMap<Integer, Integer> map;
    PriorityQueue<Integer> pq;
    int count;
    /** Initialize your data structure here. */
    public LC362_DesignHitCounter() {
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        count++;
        if(map.containsKey(timestamp)){
            map.put(timestamp, map.get(timestamp) + 1);
        }else{
            map.put(timestamp, 1);
            pq.add(timestamp);
        }
        int val = 0;
        while(!pq.isEmpty() && pq.peek() <= timestamp - 300){
            val = pq.poll();
            count -= map.get(val);
            map.remove(val);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int val = 0;
        while(!pq.isEmpty() && pq.peek() <= timestamp - 300){
            val = pq.poll();
            count -= map.get(val);
            map.remove(val);
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */