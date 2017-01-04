import java.util.*;
import java.io.*;
/*
	vanilla method:  brute force
*/
public class LC422_ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
        if(words.size() != words.get(0).length()) return false;
        int size = words.size();
        int len = 0;
        String str = null;
        //String str2 = null;
        for(int i = 0; i < size; i++){
        	str = words.get(i);
        	len = str.length();
        	for(int j = 0; j < len; ++j){
        		if(j >= size) return false;   // avoid out of boundary
        		if(i >= words.get(j).length()) return false;  // avoid out of boundary
        		if(words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
        	}
        }
        return true;
    }
}