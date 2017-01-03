import java.util.*;

public class LC246_StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
     	if(num == null || num.length() == 0) return true;
     	HashSet<Character> set = new HashSet<>();
     	set.add('1');
     	set.add('0');
     	set.add('8');
     	set.add('6');
     	set.add('9'); 
     	char ch1 = ' ', ch2 = ' ';
     	int left = 0, right = num.length() - 1;
     	while(left < right){
     		ch1 = num.charAt(left++);
     		ch2 = num.charAt(right--);
     		if(!set.contains(ch1) || !set.contains(ch2)) return false;
     		switch(ch1){
     			case '1':
     			case '0':
     			case '8': if(ch1 != ch2) return false;
     					  break;
     			case '6': if(ch2 != '9') return false;
     					  break;
     			case '9': if(ch2 != '6') return false;
     				      break;
     		}
     	}
     	if(left == right){
     		ch1 = num.charAt(left);
     		if(!set.contains(ch1)) return false;
     		if(ch1 == '9' || ch1 == '6') return false;
     	}
     	return true;
    }
}