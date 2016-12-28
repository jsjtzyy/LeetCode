import java.util.*;
/*
	Method: traverse the array, use the value as index and access the element.
	1st Mark: set negative to indicate current position has corresponding value;
	2nd Mark: subtract current negative value by (nums.length + 1);
	Extract the original value:  Math.abs(nums[i]) % (len + 1);
*/
public class LC442_FindAllDuplicates{
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		int len = nums.length;
		int val = 0;
		for(int i = 0; i < len; ++i){              // O(n) time complexity and no more extra space
			val = Math.abs(nums[i]) % (len + 1);
			if(nums[val - 1] > 0){
				nums[val - 1] = - nums[val - 1];
			}else{
				nums[val - 1] -= (len + 1);
			}
		}
		for(int i = 0; i < len; ++i){
			if(nums[i] < - (len + 1)){
				res.add(i + 1);
			}
		}
		return res;
	}
}