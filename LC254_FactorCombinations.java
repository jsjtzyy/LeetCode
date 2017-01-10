import java.util.*;
/*
	Backtracking 
*/
public class LC254_FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        for(int i = 2; i < n; ++i){
        	if( n % i == 0){
        		sol.add(i);
        		helper(res, sol, n / i, i);
        		sol.remove(0);
        	}
        }
    	return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> sol, int value, int prev){
    	if(value == 1){
    		List<Integer> list = new ArrayList<>(sol);
    		res.add(list);
    		return;
    	}
    	for(int i = prev; i <= value; ++i){
    		if(value % i == 0){
    			sol.add(i);
    			helper(res, sol, value / i, i);
    			sol.remove(sol.size() - 1);
    		}
    	}
    }
}