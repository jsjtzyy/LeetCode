import java.util.*;

public class LC243_ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0) return 0;
		int len = words.length;
		int minDist = Integer.MAX_VALUE, prevIndex = -1;
		int prevWord = 0;  // 0 -- not find word1 and word2 yet, 1 -- word1, 2 -- word2;
		for(int i = 0; i < len; ++i){
			if(words[i].equals(word1)){
				if(prevWord == 2){
					minDist = Math.min(minDist, i - prevIndex);
				}
				prevIndex = i;
				prevWord = 1;
			}else if (words[i].equals(word2)){
				if(prevWord == 1){
					minDist = Math.min(minDist, i - prevIndex);
				}
				prevIndex = i;
				prevWord = 2;
			}
		}
		return minDist;
	}
}