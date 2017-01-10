import java.util.*;
/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k 
with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
*/
public class LC259_3SumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int res = 0, twoSum = 0;
        map.put(nums[0] + nums[1], 1);
        for(int i = 2; i < len; ++i){
        	for(Integer sum : map.keySet()){
        		if(sum + nums[i] < target) res += map.get(sum);
        	}
        	for(int j = 0; j < i; ++j){
        		twoSum = nums[i] + nums[j];
        		if(map.containsKey(twoSum)){
        			map.put(twoSum , map.get(twoSum) + 1);
        		}else{
        			map.put(twoSum, 1);
        		}
        	}
        }
        return res;
    }
}
/*   TOP SOLUTION

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);                  // O(nlogn)
        int len = nums.length;
    
        for(int i=0; i<len-2; i++) {            // O(n^2)
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }

*/

