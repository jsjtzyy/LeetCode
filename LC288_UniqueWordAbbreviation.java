import java.util.*;

public class LC288_UniqueWordAbbreviation {
	HashMap<String, Integer> dicMap;
    HashMap<String, Integer> map;
    public LC288_UniqueWordAbbreviation(String[] dictionary) {
        dicMap = new HashMap<>();
        map = new HashMap<>();
        String tmp = null;
        int len = 0;
        for(String str : dictionary){
            if(dicMap.containsKey(str)){
                dicMap.put(str, dicMap.get(str) + 1);
            }else{
                dicMap.put(str, 1);
            }
            len = str.length() - 2;
            if(len > 0){
                tmp = String.valueOf(str.charAt(0)) + len + String.valueOf(str.charAt(len + 1));
                if(!map.containsKey(tmp)){
                    map.put(tmp, 1);
                }else{
                    map.put(tmp, map.get(tmp) + 1);
                }
            }else{
                if(!map.containsKey(str)){
                    map.put(str, 1);
                }else{
                    map.put(str, map.get(str) + 1);
                }
            }
        }
    }
    // no other word has same abbreviation. 
    public boolean isUnique(String word) {
        String tmp = null;
        int len = word.length() - 2;
        if(len > 0){
            tmp = String.valueOf(word.charAt(0)) + len + String.valueOf(word.charAt(len + 1));
            if(!map.containsKey(tmp)){
                return true;
            }else{
                if(!dicMap.containsKey(word)) return false;
                if(map.get(tmp) == dicMap.get(word)) return true;
                return false;
            }
        }
        if(!map.containsKey(word)){
            return true;
        }
        if(!dicMap.containsKey(word)) return false;
        if(map.get(word) == dicMap.get(word)) return true;
        return false;
    }
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");