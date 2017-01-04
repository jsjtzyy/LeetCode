import java.util.*;

public class LC249_GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings == null || strings.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        StringBuilder sb = null;
        String gap = null;
        List<String> list = null;
        int dist = 0;
        for(String str : strings){
        	sb = new StringBuilder("0");
        	for(int i = 1; i < str.length(); ++i){
        		dist = str.charAt(i) - str.charAt(i - 1);
        		dist = (dist + 26) % 26;
        		if(dist > 9){
        			sb.append(String.valueOf(dist));
        		}else{
        			sb.append("0" + String.valueOf(dist));
        		}
        	}
        	gap = sb.toString();
        	if(map.containsKey(gap)){
        		list = map.get(gap);
        	}else{
        		list = new ArrayList<>();
        	}
        	list.add(str);
        	map.put(gap, list);
        }
        for(List<String> tmp : map.values()){
        	res.add(tmp);
        }
        return res;
    }
}