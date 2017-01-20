import java.util.*;

public class LC356_LineReflection {
	public boolean isReflected(int[][] points) {
    	if(points == null || points.length == 0 || points[0].length == 0) return true;
    	int len = points.length;
    	HashSet<String> set = new HashSet<>();
    	Comparator<int[]> cmpMin = new Comparator<int[]>(){
    		public int compare(int[] p1, int[] p2){
    			return p1[0] - p2[0];
    		}
    	};

    	Comparator<int[]> cmpMax = new Comparator<int[]>(){
    		public int compare(int[] p1, int[] p2){
    			return p2[0] - p1[0];
    		}
    	};

    	Queue<int[]> minHeap = new PriorityQueue<>(len, cmpMin);
    	Queue<int[]> maxHeap = new PriorityQueue<>(len, cmpMax);

    	for(int[] point : points){
    	    if(set.contains(point[0] + " " + point[1])) continue;
    		minHeap.add(new int[]{point[0], point[1]});
    		maxHeap.add(new int[]{point[0], point[1]});
    		set.add(point[0] + " " + point[1]);
    	}
    	int cnt = 0;
    	int[] right = maxHeap.poll();
    	int[] left = minHeap.poll();
    	int x = right[0] + left[0];
    	if(left[1] != right[1]) return false;
    	cnt = 2;
    	len = set.size();
    	HashSet<Integer> setLeft = new HashSet<>();
    	HashSet<Integer> setRight = new HashSet<>();
    	while(cnt < len){
    		right = maxHeap.poll();
    		left = minHeap.poll();
    		if(x != left[0] + right[0]) return false;
    		if(left[0] != right[0]){
    		    setLeft = new HashSet<>();
    		    setRight = new HashSet<>();
    		    setLeft.add(left[1]); setRight.add(right[1]);
        		while(maxHeap.peek()[0] == right[0]){  // if several points have same x value, we should group their y value up and check if values in left group and right group match or not.
        		    setRight.add(maxHeap.poll()[1]);
        		}
        		while(minHeap.peek()[0] == left[0]){
        		    setLeft.add(minHeap.poll()[1]);
        		}
        		if(setLeft.size() != setRight.size()) return false;
        		for(Integer num : setLeft){
        		    if(!setRight.contains(num)) return false;
        		}
        		cnt += 2 * setLeft.size();
    		}else{
    		    cnt += 2;  // two points fall on the symmetric line, unnecessary to check y value
    		}
    	}
    	return true;
    }
}