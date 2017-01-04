import java.util.*;
// use the regular expression, \s stands for arbitary space including \tab and " "
// "+" means repeated arbitary times
public class LC434_NumberOfSegments {
	public int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();		// reomve tailing and leading spaces.
        String[] words = s.split("\\s+");
        if(words.length == 1 && words[0].length() == 0) return 0;  // corner case: "        "   
        return words.length;
    }
}
