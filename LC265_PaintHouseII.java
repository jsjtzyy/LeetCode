import java.util.*;

public class LC265_PaintHouseII {
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int row = costs[0].length, col = costs.length;
        if(row == 1) return costs[0][0];   // in case there is only one color.
        int[][] minTwo = new int[2][2]; // first value, second index.
        Comparator<int[]> cmp = new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2){
                return pair1[0] - pair2[0];
            }
        };
        Queue<int[]> pq = new PriorityQueue<>(row, cmp);
        for(int i = 0; i < row; ++i){
        	pq.add(new int[]{costs[0][i], i});
        }
        int cnt = 0;
        while(cnt < 2){
        	minTwo[cnt++] = pq.poll();
        }
        System.out.println(minTwo[0][0] + " " + minTwo[1][0]);
        for(int j = 1; j < col; ++j){
        	pq = new PriorityQueue<>(row, cmp);
        	for(int i = 0; i < row; ++i){
        		if(i == minTwo[0][1]){  // equals min index
        			pq.add(new int[]{minTwo[1][0] + costs[j][i], i});
        		}else{
        			pq.add(new int[]{minTwo[0][0] + costs[j][i], i});
        		}
        	}
        	cnt = 0;
        	while(cnt < 2){  // get the minimum two values
        		minTwo[cnt++] = pq.poll();
        	}
        	System.out.println(minTwo[0][0] + " " + minTwo[1][0]);
        }
        return minTwo[0][0];   
    }
}