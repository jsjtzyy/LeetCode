import java.util.*;

public class LC451_SortCharByFreq{
	public String frequencySort(String s) {
		if(s == null || s.length() == 0) return new String();
		HashMap<Character, Integer> map = new HashMap<>();
		Map<Integer, String> treemap = new TreeMap<>();
		char[] arr = s.toCharArray();
		for(char ch : arr){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			}else{
				map.put(ch, 1);
			}
		}
		StringBuilder sb = null;
		int cnt = 0;
		for(Character ch : map.keySet()){
			sb = new StringBuilder();
			cnt = map.get(ch);
			for(int i = cnt - 1; i >= 0; --i){
				sb.append(String.valueOf(ch));
			}
			if(treemap.containsKey(cnt)){
				sb.append(treemap.get(cnt));
				treemap.put(cnt, sb.toString());
			}else{
				treemap.put(cnt, sb.toString());
			}
		}
		//StringBuilder sb = new StringBuilder();
		int index = arr.length - 1;
		sb = new StringBuilder();
		String str = null;
		for(Integer freq : treemap.keySet()){
			str = treemap.get(freq);
			sb.append(str);
		}
		sb.reverse();
		return sb.toString();
	}
}