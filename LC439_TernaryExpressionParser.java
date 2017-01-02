import java.util.*;
/*
	use the stack and traverse from the end of string
	when encoutnering '?', pop out the toppest two characters in stack, and choose the correct
	to push back to stack based on character before '?'
*/
public class LC439_TernaryExpressionParser {
	public String parseTernary(String expression) {
		String res = new String();
        Stack<Character> stack = new Stack<>();  
        if(expression == null || expression.length() < 5) return res;
        char ch = ' ', first = ' ', second = ' ';
        int len = expression.length();
        for(int i = len - 1; i >= 0; --i){
        	ch = expression.charAt(i);
        	if(ch == 'T' || ch == 'F' || (ch >= '0' && ch <= '9')){
        		stack.push(ch);
        	}else if(ch == '?'){
        		first = stack.pop();
        		second = stack.pop();
        		if(expression.charAt(--i) == 'T'){
        			stack.push(first);
        		}else{
        			stack.push(second);
        		}
        	}
        }
        return String.valueOf(stack.pop());
    }
}