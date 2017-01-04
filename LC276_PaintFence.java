import java.util.*;
import java.io.*;
/* Problem:
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence. */

/*
	remark1: "no more than two" means two is acceptable and 3 consecutive posts with same color is not acceptable
	remark2: The fence is a line not a circle.
*/

public class LC276_PaintFence {
	/* Solution 1:
	pure mathematic problem and solution using the recursive formula：
	sum = M + C^{1}_{n-1} * M/(k - 1) + C^{2}_{n-2} * M/(k - 1)^2 + ... C^{p}_{n-p} * M/(k - 1)^p
	where p = n / 2, M = (k - 1)^(n - 1)
	Final result = k * sum
	*/
    public int numWays1(int n, int k) {
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

    /* Solution 2:
    	Dynamic Programming, build a 2D array:  dp[2][n]
    	dp[0][i] indicates total cases where post i and post i - 1 have different colors.
    	dp[1][i] indicates total cases where post i and post i - 1 have the same color.
    	Transfer equation:
    		dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) * (k - 1);
        	dp[1][i] = dp[0][i - 1] * 1;
    */
   	public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0; // corner case
        if(k == 1 && n > 2) return 0; // corner case
        if(k == 1) return 1; // corner case
        int[][] dp = new int[2][n];
        dp[0][0] = k;
        dp[1][0] = 0;
        for(int i = 1; i < n; ++i){
            dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) * (k - 1);// A(i) != A(i - 1)
            dp[1][i] = dp[0][i - 1] * 1;   // A(i) = A(i - 1)
        }
        return dp[0][n - 1] + dp[1][n - 1];
   	}

}