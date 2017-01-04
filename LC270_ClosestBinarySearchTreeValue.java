import java.util.*;

public class LC270_ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        TreeNode node = root;
        boolean rightChanged = false, leftChanged = false;
        while(node != null){
        	if(target > node.val){
        		left = node.val;
        		node = node.right;
        		leftChanged = true;
        	}else{
        		right = node.val;
        		node = node.left;
        		rightChanged = true;
        	}
        }
        if(!rightChanged) return left;
        if(!leftChanged) return right;
        double mid = ((double)left + (double)right)/2;
        if(target > mid) return right;
        return left;
    }
}