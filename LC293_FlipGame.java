import java.util.*;
public class LC293_FlipGame{
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 2) return res;
        int len = s.length();
        char[] chArray = s.toCharArray();
        for(int i = 0; i < len - 1; ++i){
        	if(chArray[i] == chArray[i + 1]){
        		if(chArray[i] == '+'){
        			res.add(s.substring(0, i) + "--" + s.substring(i + 2));
        		}
        	}
        }
        return res;
    }
}