import java.util.*;

public class LC170_TwoSumIII_Design {
	Map<Integer, Integer> map;
	public LC170_TwoSumIII_Design(){
	    map = new HashMap<>();
	}

	// Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)){
	        map.put(number, 2);
	    }else{
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if(value % 2 == 0 && map.containsKey(value / 2)){
	        if(map.get(value / 2) == 2) return true;
	        map.remove(value / 2);
	        for(Integer num : map.keySet()){
	            if(map.containsKey(value - num)) {
	                map.put(value / 2, 1);
	                return true;
	            }
	        }
	        map.put(value / 2, 1);
	    }else{
	        for(Integer num : map.keySet()){
	            if(map.containsKey(value - num)) return true;
	        }
	    }
	    return false;
	}
}