import java.util.*;

public class LC370_RangeAddition{
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if(updates == null || updates.length == 0) return res;
        int start = 0, end = 0, val = 0;
        for(int i = 0; i < updates.length; ++i){ // only start and end + 1 elements need to be updated
            start = updates[i][0];
            end = updates[i][1];
            val = updates[i][2];
            res[start] += val;               // indicates that there is an increment val from start element.
            if(end + 1 < length) res[end + 1] -= val; // indicates that there is a decrement val from (end + 1) element.
        }
        int curVal = 0;                    //all operations affect curVal by adding val at start element
                                           // and cancel the effect by subtracting val at end + 1 element.
        for(int i = 0; i < length; ++i){
            curVal += res[i];     // curVal is updated based on updated start/end elements in first loop
            res[i] = curVal;
        }
        return res;
    }
}