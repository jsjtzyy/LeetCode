import java.util.*;

public class LC492_ConstructRectangle{
	public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int left = 1, right = area, mid = 0;
        long tmp = 0;
        while(left < right - 1){    // binary search  
        	mid = (left + right) / 2;
        	tmp = (long)mid * (long)mid;
        	if(tmp ==(long)area) {left = mid; break;}
        	if(tmp < (long)area) left = mid;
        	else right = mid - 1;
        }
        tmp = (long)right * (long)right;
        if(tmp <= (long)area) left = right;
        while(area % left != 0){
        	--left;
        }
        res[0] = area / left;
        res[1] = left;
        return res;     
    }
}