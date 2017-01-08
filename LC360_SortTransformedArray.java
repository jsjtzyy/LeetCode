/*
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)
*/

import java.uti.*;

public class LC360_SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        int len = res.length;
        if(a == 0 && b == 0) {
        	if(c == 0) return res;
        	for(int i = res.length - 1; i >= 0; --i) res[i] = c;
        	return res;
        }

        if(a == 0){
        	if(b > 0){
        		for(int i = 0; i < len; ++i){
        			res[i] = b * nums[i] + c;
        		}
        	}else{
        		for(int i = 0; i < len; ++i){
        			res[len - 1 - i] = b * nums[i] + c;
        		}
        	}
        	return res;
        }
        double axis = 0.0;
        axis = -(double)b/(2 * a);
        // binary search
        int left = 0, right = len - 1, mid = 0, index = 0;
        while(left < right - 1){
        	mid = (left + right) / 2;
        	if(nums[mid] == axis) break;
        	if(nums[mid] > axis){
        		right = mid;
        	}else{
        		left = mid;
        	}
        }
        if(mid == 0){
        	left = mid;
        	right = mid + 1;
        }else if(mid == len - 1){
        	left = mid - 1;
        	right = mid;
        }else if(nums[mid] == axis){
            left = mid - 1;
            right = mid;
        }
        if(a > 0){
        	while(left >= 0 && right < len){
        		if(nums[left] + nums[right] - 2 * axis >= 0){
        			res[index++] = a * nums[left] * nums[left] + b * nums[left] + c;
        			--left;
        		}else{
        			res[index++] = a * nums[right] * nums[right] + b * nums[right] + c; 
        			++right;
        		}
        	}
        	while(left >= 0){
				res[index++] = a * nums[left] * nums[left] + b * nums[left] + c;
        		--left;        	
        	}
        	while(right < len){
        		res[index++] = a * nums[right] * nums[right] + b * nums[right] + c; 
        		++right;        		
        	}
        }else{
        	index = len - 1;
        	while(left >= 0 && right < len){
        		if(nums[left] + nums[right] - 2 * axis >= 0){
        			res[index--] = a * nums[left] * nums[left] + b * nums[left] + c;
        			--left;
        		}else{
        			res[index--] = a * nums[right] * nums[right] + b * nums[right] + c; 
        			++right;
        		}
        	}
        	while(left >= 0){
				res[index--] = a * nums[left] * nums[left] + b * nums[left] + c;
        		--left;        	
        	}
        	while(right < len){
        		res[index--] = a * nums[right] * nums[right] + b * nums[right] + c; 
        		++right;        		
        	}        	
        }
        return res;
    }
}