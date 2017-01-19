import java.util.*;
/*
	time complexity: 4 * m * n
	space complexity: m * n
*/
public class LC361_BombEnemy{
	public int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length, col = grid[0].length;
		int[][] dp = new int[row][col];
		int cnt = 0;
		for(int i = 0; i < row; ++i){
			cnt = 0;
			for(int j = 0; j < col; ++j){
				if(grid[i][j] == 'E') ++cnt;
				else if(grid[i][j] == 'W') {dp[i][j] = cnt;	cnt = 0;}
			}
			for(int j = col - 1; j >= 0; --j){
				switch(grid[i][j]){
					case 'E': break;
					case 'W': cnt = dp[i][j]; break;
					case '0': dp[i][j] += cnt; break;
					default:  break; 
				}
			}
		}

		for(int j = 0; j < col; ++j){
			cnt = 0;
			for(int i = 0; i < row; ++i){
				if(grid[i][j] == 'E') ++cnt;
				else if(grid[i][j] == 'W'){
					dp[i][j] = cnt;
					cnt = 0;
				}
			}
			for(int i = row - 1; i >= 0; --i){
				switch(grid[i][j]){
					case 'E': break;
					case 'W': cnt = dp[i][j]; break;
					case '0': dp[i][j] += cnt; res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
	}
}