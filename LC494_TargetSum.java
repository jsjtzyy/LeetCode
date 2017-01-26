import java.util.*;
/*
	BFS:  use two hashmaps: cur and next to record previous results.
*/
public class LC494_TargetSum{
	public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> cur = new HashMap<>();

        /*initialize first element*/
        cur.put(nums[0], 1);
        if(nums[0] != 0) cur.put(-nums[0], 1);
        else cur.put(0, 2);


        int tmp = 0;
        HashMap<Integer, Integer> next = null;
        for(int i = 1; i < nums.length; ++i){
            next = new HashMap<>();
            for(Integer num : cur.keySet()){   // traverse previous result
                tmp = num + nums[i];
                if(next.containsKey(tmp)){
                    next.put(tmp, next.get(tmp) + cur.get(num));
                }else{
                    next.put(tmp, cur.get(num));
                }
                tmp = num - nums[i];
                if(next.containsKey(tmp)){
                    next.put(tmp, next.get(tmp) + cur.get(num));
                }else{
                    next.put(tmp, cur.get(num));
                }
            }
            cur = next;  // update current result set
        }
        if(cur.containsKey(S)) return cur.get(S);
        return 0;
    }
}