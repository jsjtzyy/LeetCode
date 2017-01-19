import java.util.*;

public class LC159_LongestSubstringTwoDistinctChars{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		Map<Integer, Character> treemap = new TreeMap<>();
		if(s == null || s.length() == 0) return 0;
		int len = s.length();
		int res = 0, start = 0;
		char ch = ' ', prev = ' ';
		prev = s.charAt(0);
		map.put(prev, 0);
		treemap.put(0, prev);
		for(int i = 1; i < len; ++i){
			ch = s.charAt(i);
			if(map.size() < 2){
				if(ch != prev){
				    if(map.containsKey(ch)){
				        treemap.remove(map.get(ch));
				    }
					map.put(ch, i);
					treemap.put(i, ch);
					prev = ch;
				}
			}else{
				if(ch != prev){
					if(map.containsKey(ch)){
						treemap.remove(map.get(ch));
						map.put(ch, i);
						treemap.put(i, ch);
					}else{  // new character and map is full, the character with min index should be removed.
						res = Math.max(res, i - start);
						int min = 0;
						for(Integer num : treemap.keySet()){
							min = num;
							break;
						}
						map.remove(treemap.get(min));
						treemap.remove(min);
						for(Integer num : treemap.keySet()){
							min = num;
						}
						start = min;
						treemap.put(i, ch);
						map.put(ch, i);
					}
					prev = ch;
				}
			}

		}// end of out loop for
		res = Math.max(res, len - start);   // in case of the last character belongs to substring which may not update the res
		if(res == 0 && len > 0) return len;
		return res;  
	}
}