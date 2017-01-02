import java.util.*;

public class LC244_ShortestWordDistanceII {
	HashMap<String, ArrayList<Integer>> map;

	public WordDistance(String[] words) {
        map = new HashMap<>();
        ArrayList<Integer> list = null;
        for(int i = 0; i < words.length; ++i){
        	if(map.containsKey(words[i])){
        		list = map.get(words[i]);
        	}else{
        		list = new ArrayList<>();
        	}
        	list.add(i);
        	map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {  // Time complexity = O(mlog(n))  m < n
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0, mid = 0;
        if(list1.size() > list2.size())				// Binary Search
        {
        	for(Integer target : list2){
        		left = 0;
        		right = list1.size() - 1;
        		while(left < right - 1){
        			mid = (left + right) / 2;
        			if(target > list1.get(mid)){
        				left = mid;
        			}else{
        				right = mid;
        			}
        		}
        		res = Math.min(res, Math.min(Math.abs(target - list1.get(left)), Math.abs(target - list1.get(right))));
        	}
        }else{
			for(Integer target : list1){
        		left = 0;
        		right = list2.size() - 1;
        		while(left < right - 1){
        			mid = (left + right) / 2;
        			if(target > list2.get(mid)){
        				left = mid;
        			}else{
        				right = mid;
        			}
        		}
        		res = Math.min(res, Math.min(Math.abs(target - list2.get(left)), Math.abs(target - list2.get(right))));
        	}
        }
        return res;
    }
}