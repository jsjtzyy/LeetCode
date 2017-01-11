import java.util.*;
/*
	use recursion
*/
public class LC247_StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        if(n == 1) {
        	res.add("0");
        	res.add("1");
        	res.add("8");
        	return res;
        }
        if(n == 2) {
        	res.add("11");
        	res.add("69");
        	res.add("88");
        	res.add("96");
        	return res;
        }
        List<String> list = helper(n - 2);
        for(String str : list){
        	res.add("1" + str + "1");
        	res.add("8" + str + "8");
        	res.add("6" + str + "9");
        	res.add("9" + str + "6");
        }
        return res;
    }

    public List<String> helper(int n) {
    	List<String> res = new ArrayList<>();
    	if(n == 1) {
        	res.add("0");
        	res.add("1");
        	res.add("8");
        	return res;
        }
        if(n == 2) {
        	res.add("00");
        	res.add("11");
        	res.add("69");
        	res.add("88");
        	res.add("96");
        	return res;
        }
        List<String> list = helper(n - 2);
        for(String str : list){
        	res.add("0" + str + "0");
        	res.add("1" + str + "1");
        	res.add("8" + str + "8");
        	res.add("6" + str + "9");
        	res.add("9" + str + "6");
        }
        return res;
    }
}