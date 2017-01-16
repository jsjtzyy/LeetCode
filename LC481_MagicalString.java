import java.util.*;

public class LC481_MagicalString {
	public int magicalString(int n) {
    	int cur = 2, end = 3, res = 1;
    	if(n == 0) return 0;
    	if(n <= 3) return 1;
    	ArrayList<Integer> list = new ArrayList<>();
    	list.add(1);
    	list.add(2);
    	list.add(2);    
    	while(end < n){
    		if(list.get(cur) == 1){
    			if(list.get(end - 1) == 1){
    				list.add(2);
    			}else{
    				list.add(1);
    				++res;
    			}
    			++end;
    		}else{
    			if(list.get(end - 1) == 1){
    				list.add(2);
    				list.add(2);
    			}else{
    				list.add(1);
    				list.add(1);
    				res += 2;
    			}
    			end += 2;
    		}
    		++cur;
    	}
    	if(n < end){
    		if(list.get(end - 1) == 1) res--;
    	}
    	return res;
    }
}