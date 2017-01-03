import java.util.*;
/*
	Dynameic programmming
	For i th house:
		 the accumlative cost of red is based on previous blue and green;
		 the accumlative cost of green is based on previous blue and red;
		 the accumlative cost of blue is based on previous red and green;
*/
public class LC256_PaintHouse {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        int[][]res = new int[costs.length][3];
        res[0][0] = costs[0][0];
        res[0][1] = costs[0][1];
        res[0][2] = costs[0][2];
        for(int i = 1; i < res.length; ++i){
        	res[i][0] = Math.min(res[i - 1][1] , res[i - 1][2]) + costs[i][0];
        	res[i][1] = Math.min(res[i - 1][0] , res[i - 1][2]) + costs[i][1];
        	res[i][2] = Math.min(res[i - 1][0] , res[i - 1][1]) + costs[i][2];
        }
        return Math.min(res[len - 1][0], Math.min(res[len - 1][1], res[len - 1][2]));
    }
}