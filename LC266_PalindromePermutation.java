import java.util.*;
public class LC266_PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        char ch = ' ';
        for(int i = s.length() - 1; i >= 0; --i){
        	ch = s.charAt(i);
        	if(set.contains(ch)){
        		set.remove(ch);
        	}else{
        		set.add(ch);
        	}
        }
        if(set.size() > 1) return false;
        return true;
    }
}