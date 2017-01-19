import java.util.*;

public class LC340_LongestSubstringKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		Map<Integer, Character> treemap = new TreeMap<>();
		if(s == null || s.length() == 0 || k == 0) return 0;
		int len = s.length();
		int res = 0, start = 0;
		char ch = ' ', prev = ' ';
		prev = s.charAt(0);
		map.put(prev, 0);
		treemap.put(0, prev);
		for(int i = 1; i < len; ++i){
			ch = s.charAt(i);
			if(map.size() < k){
				    if(map.containsKey(ch)){
				        treemap.remove(map.get(ch));
				    }
					map.put(ch, i);
					treemap.put(i, ch);  // record the last index of a sepcific character
			}else{
					if(map.containsKey(ch)){
						treemap.remove(map.get(ch));
						map.put(ch, i);
						treemap.put(i, ch); // record last index;
					}else{  // new character and map is full, the character with min last index should be removed.
						res = Math.max(res, i - start);
						int min = 0;
						for(Integer num : treemap.keySet()){
							min = num;
							break;
						}
						map.remove(treemap.get(min));
						treemap.remove(min);
						start = min + 1;  // update the start with last index + 1
						treemap.put(i, ch);
						map.put(ch, i);
					}
			}

		}// end of out loop for
		res = Math.max(res, len - start);   // in case of the last character belongs to substring which may not update the res
		if(res == 0 && len > 0) return len;
		return res;          
    }
}