import java.util.*;
import java.io.*;
/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.
*/

/*
	remark: "no more than two" means two is acceptable and 3 consecutive posts with same color is not acceptable
	remark2: The fence is a line not a circle.
*/

/*
	pure mathematic problem and solution
*/
public class LC276_PaintFence {
	public int numWays(int n, int k) {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(k == 1 && n > 2) return 0;
        if(k == 1) return 1;
		long product = 1;
        for(int i = 1; i <= n - 1; ++i){
        	product *= (k - 1);
        }
        int upperlimit = n / 2;
        long factor = product/(k - 1), numerator = n - 1, denominator = 1;
        long quotient = numerator / denominator;
        long sum = product + quotient * factor;
        for(int i = 2; i <= upperlimit; ++i){
        	factor /= (k - 1);
        	//denominator *= i;
        	// pay attention to OVERFLOW AND Integer Division !!!
        	quotient = quotient  * (n - 2 * (i - 1)) * (n - 2 * (i - 1) - 1) / (n - (i - 1)) / i; 

        	sum += quotient * factor;

        	//numerator = numerator / (n - i) * (n - 2 * i) * (n - 2 * i - 1);
        }
        return k * (int)sum;
    }
}