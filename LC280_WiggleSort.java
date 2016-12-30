import java.util.*;
public class LC280_WiggleSort{
	/*method 1:  Use Quick Sort and swap the adjacent elements; */
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length < 2) return;
        Arrays.sort(nums);   // Time Complexity = O(nlogn)
        for(int i = 1; i < nums.length - 1; i = i + 2){
        	nums[i] ^= nums[i + 1];
        	nums[i + 1] ^= nums[i];
        	nums[i] ^= nums[i + 1];
        }
    }

    public void wiggleSort2(int[] nums){
    	boolean needAscend = true;
    	for(int i = 0; i < nums.length - 1; ++i){  // Time complexity(O(n))
    		if(needAscend){
    			if(nums[i] > nums[i + 1]){
		        	nums[i] ^= nums[i + 1];
		        	nums[i + 1] ^= nums[i];
		        	nums[i] ^= nums[i + 1];
    			}
    			needAscend = false;
    		}else{
    			if(nums[i] < nums[i + 1]){
		        	nums[i] ^= nums[i + 1];
		        	nums[i + 1] ^= nums[i];
		        	nums[i] ^= nums[i + 1];
    			}
    			needAscend = true;
    		}
    	}
    }
}