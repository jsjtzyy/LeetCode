import java.util.*;
import java.io.*;

public class LC408_ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
    	if(word == null || abbr == null) return false;
    	int wLen = word.length(), aLen = abbr.length();
    	char ch = ' ';
    	int cnt = 0;
    	int index = -1;
    	for( int i = 0; i < aLen; ++i){
    		ch = abbr.charAt(i);
    		if('a' <= ch && ch <= 'z' || ch == '0'){  // ch == '0' removing the cases in which there is leading zeros
    			++index;
    			if(index >= wLen || ch != word.charAt(index)) return false;
    		}else{
    			cnt = 0;
    			//if(i < aLen - 1) ch = abbr.charAt(++i);
    			while('0' <= ch && ch <= '9' && i < aLen){
    				cnt = cnt * 10 + ch - '0';
    				if(i == aLen - 1){
    					++i;
    					break;
    				}
    				ch = abbr.charAt(++i);
    			}
    			index += cnt + 1;
    			if(index == wLen && i == aLen) return true;
    			if(index >= wLen || ch != word.charAt(index)) return false;
    		}
    	} 
    	if(index != wLen - 1) return false;
    	return true;    
    }
}

