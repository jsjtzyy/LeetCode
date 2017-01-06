import java.util.*;
/*
	BFS
*/
public class LC320_GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if(word == null || word.length() == 0) {
            res.add(new String());
            return res;
        }
        Queue<String> cur = new LinkedList<>();
        int index = 0, len = word.length();
        cur.offer(word.substring(index, index + 1));
        cur.offer("1");
        String tmp = null;
        int cnt = 0;
        char ch = ' ';
        Queue<String> next = null;
        ++index;
        while(index < len){
        	next = new LinkedList<>();
        	while(!cur.isEmpty()){
        		tmp = cur.poll();
        		cnt = tmp.length() - 1;
        		while(cnt >= 0){
        			ch = tmp.charAt(cnt);
        			if(Character.isLetter(ch)) break;
                    cnt--;
        		}
        		if(cnt == tmp.length() - 1)
        			next.offer(tmp + "1");
        		else
        			next.offer(tmp.substring(0, cnt + 1) + (Integer.parseInt(tmp.substring(cnt + 1, tmp.length())) + 1));
        		next.offer(tmp + word.substring(index, index + 1));
        	}
        	cur = next;
        	++index;
        }
        while(!cur.isEmpty()){
        	res.add(cur.poll());
        }
        return res;
    }
}