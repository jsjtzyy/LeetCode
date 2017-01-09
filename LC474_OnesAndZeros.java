import java.util.*;
/*
	Dynamic programming (similar to knapsack problem)
	m -- 0,  n -- 1;
*/
public class LC474_OnesAndZeros {
	public int findMaxForm(String[] strs, int m, int n) {
		if(strs == null || strs.length == 0) return 0;
        int len = strs.length;
        int[] arr0 = new int[len];
        int[] arr1 = new int[len];
        int cnt0 = 0, cnt1 = 0;
        for(int k = 0; k < len; ++k){
        	cnt0 = 0;
        	cnt1 = 0;
        	for(int i = strs[k].length() - 1; i >= 0; --i){
        		if(strs[k].charAt(i) == '0') {
        			++cnt0;
        		}else{
        			++cnt1;
        		}
        	}
        	arr0[k] = cnt0;
        	arr1[k] = cnt1;
        }    	
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for(int i = 1; i <= len; ++i){
        	for(int j = 0; j <= m; ++j){
        		for(int k = 0; k <= n; ++k){
        			if(arr0[i - 1] <= j && arr1[i - 1] <= k){
        				dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - arr0[i - 1]][k - arr1[i - 1]]);
        			}else{
        				dp[i][j][k] = dp[i - 1][j][k];
        			}
        		}
        	}
        }
        return dp[len][m][n];
    }
}