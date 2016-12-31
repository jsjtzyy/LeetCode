import java.util.*;

public class LC294_FlipGameII{
	public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        char[] arr = s.toCharArray();
        return check(arr);
    }
    
    // Use recursion to consider all the possible cases.
    // Suppose A can first move, B moves after A's move.
    public boolean check( char[] arr){
    	boolean winFlag = true;
    	for(int i = 0; i < arr.length - 1; ++i){       // outer loop consider all the choices for A
    		if(arr[i] == arr[i + 1] && arr[i] == '+'){
    			arr[i] = '-';
    			arr[i + 1] = '-';
    			winFlag = true;
	    		for(int j = 0; j < arr.length - 1; ++j){ // inner loop consider all choices for B
		    		if(arr[j] == arr[j + 1] && arr[j] == '+'){
		    			arr[j] = '-';
		    			arr[j + 1] = '-';
		    			if(!check(arr)){
		    				winFlag = false;
		    			}
		    			arr[j] = '+';
		    			arr[j + 1] = '+';
		    			if(!winFlag) break;  // if there is a case where A cannot win after B's move, then previous A's move is not acceptable.
		    		}
	    
	    		}
	    		arr[i] = '+';
	    		arr[i + 1] = '+';
	    		if(winFlag) { // if there is a case where B cannot win no matter what he does, then A's previous move can guarantee the win.
	    			return true;
	    		}
	    		
    		}	
    	}
    	return false;
    }
}