import java.util.*;

public class LC281_ZigzagIterator {
	int v1total, v2total;
	int v1ptr;
	int v2ptr;
	int cnt;
	List<Integer> v1;
	List<Integer> v2;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v1total = v1.size();
        v2total = v2.size();
        v1ptr = 0;
        v2ptr = 0;
        cnt = 0;
        this.v1 = v1;
	    this.v2 = v2;
    }

    public int next() {
    	int res = 0;
    	if(v1ptr < v1total){
    		if(v2ptr < v2total && v1ptr > v2ptr){
    			res = v2.get(v2ptr++);
    		}else{
    			res = v1.get(v1ptr++);
    		}
    	}else{
    		res = v2.get(v2ptr++);
    	}
        ++cnt;
        return res;
    }

    public boolean hasNext() {
        return cnt < v1total + v2total;
    }

}