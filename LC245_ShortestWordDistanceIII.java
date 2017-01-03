import java.util.*;
/*
	Discuss two cases separately:
	(1) word1 doesn't equal to word2   (same as Shortest Word Distance I)
	(2) word1 equals word2
*/
public class LC245_ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0) return 0;
		int len = words.length;
		boolean sameFlag = false;
		if(word1.equals(word2)) sameFlag = true;
		int res = Integer.MAX_VALUE;
		int prevIndex = -1, prevWord = 0; 
		if(sameFlag){
			for(int i = 0; i < len; ++i){
				if(words[i].equals(word1)){
					if(prevIndex > -1){
						res = Math.min(res, i - prevIndex);
					}
					prevIndex = i;
				}
			}
		}else{
			for(int i = 0; i < len; ++i){
				if(words[i].equals(word1)){
					if(prevWord == 2){
						res = Math.min(res, i - prevIndex);
					}
					prevIndex = i;
					prevWord = 1;
				}else if(words[i].equals(word2)){
					if(prevWord == 1){
						res = Math.min(res, i - prevIndex);
					}
					prevIndex = i;
					prevWord = 2;
				}
			}
		}
		return res;
	}
}