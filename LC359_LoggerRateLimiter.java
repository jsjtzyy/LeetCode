import java.util.*;

public class LC359_LoggerRateLimiter {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public LC359_LoggerRateLimiter() {
       map = new HashMap<>(); 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp >= map.get(message) + 10){
                map.put(message, timestamp);
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * LC359_LoggerRateLimiter obj = new LC359_LoggerRateLimiter();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */