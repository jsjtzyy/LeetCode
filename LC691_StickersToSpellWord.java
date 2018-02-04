class LC691_StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        HashMap<String, HashMap<Character, Integer>> strMap = new HashMap<>();
        HashMap<Character, List<String>> charMap = new HashMap<>();
        char ch = ' ';
        List<String> list = null;
        int num = 0;
        // build strMap and charMap respectively
        for(String s : stickers){
            HashMap<Character, Integer> map = new HashMap<>();  // record # of character occurence in a single word
            for(int i = 0; i < s.length(); ++i){
                ch = s.charAt(i);
                num = map.getOrDefault(ch, 0) + 1;
                map.put(ch, num);
                list = charMap.getOrDefault(ch, new ArrayList<>());
                list.add(s);
                charMap.put(ch, list);
            }
            strMap.put(s, map);
        }
        int tLen = target.length();
        int[] tchars = new int[26];
        for(int i = 0; i < tLen; ++i)
        {
            ch = target.charAt(i);
            tchars[ch - 'a']++;
        }
        HashMap<String, Integer>cache = new HashMap<>();
        int res = helper(strMap, charMap, tchars, tLen, 'a', 0, cache);
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public int helper(HashMap<String, HashMap<Character, Integer>> strMap, HashMap<Character, List<String>> charMap, int[] tchars, int tLen, char prev, int index, HashMap<String, Integer> cache){ //HashSet<String> cache, List<Integer> tList
        if(tLen == 0) return 0;
        char curCh = ' ';
        if(tchars[prev - 'a'] <= 0){
            for(int i = prev - 'a' + 1; i < 26; i++){
                if(tchars[i] > 0) {
                    curCh = (char)(i + 'a');
                    index = 0;
                    break;
                }
            }
        }else{
            curCh = prev;
        }
        List<String> list =  charMap.getOrDefault(curCh, null);
        if(list == null) {
            return Integer.MAX_VALUE;
        }
        HashMap<Character, Integer> map = null;
        int sum = 0; // sum is used to indicate how many characters could be removed from target word
        int res = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = prev - 'a'; i < 26; i++){
            if(tchars[i] > 0) {
                sb.append((char)(i + 'a')).append(tchars[i]);
            }
        }
        String str = null, pattern = sb.toString();
        if(cache.containsKey(pattern)){
            return cache.get(pattern);
        }
        for(int j = index; j < list.size(); ++j){
            str = list.get(j);
            map = strMap.get(str);
            sum = 0;
            for(Character c : map.keySet()){
                if(tchars[c - 'a'] > 0){
                    sum += Math.min(tchars[c - 'a'], map.get(c));
                }
                tchars[c - 'a'] -= map.get(c);
            }
            if(sum > 0) {
                int tmpRes = helper(strMap, charMap, tchars, tLen - sum, curCh, j, cache);
                res = Math.min(res, tmpRes);
            }
            for(Character c : map.keySet()){ // restore
                tchars[c - 'a'] += map.get(c);
            }
            if(res == 0) {
                cache.put(pattern, 1);
                return 1;
            }
        }
        if(res == Integer.MAX_VALUE) {
            cache.put(pattern, res);
            return res;
        }
        cache.put(pattern, res + 1);
        return res + 1;
    }
}
