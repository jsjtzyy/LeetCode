import java.util.*;

public class LC450_DeleteNodeinBST {
	public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = new TreeNode(0), cur = root;
        TreeNode res = prev; // dummy node;
        prev.left = root;
        while(cur != null){
        	if(cur.val == key) break;
        	if(cur.val < key){
        		prev = cur;
        		cur = cur.right;
        	}else{
        		prev = cur;
        		cur = cur.left;
        	}
        }
        if(cur == null) return res.left; // fail to find the key in BST
        if(cur.right != null){
        	TreeNode tmp = cur.right, tmpPrev = cur;
        	if(tmp.left == null){
        		if(prev.left == cur) prev.left = tmp;
        		else prev.right = tmp;
        		tmp.left = cur.left;
        	}else{
        		while(tmp.left != null) {
        			tmpPrev = tmp;
        			tmp = tmp.left;
				}
				tmpPrev.left = tmp.right;
				if(prev.left == cur) prev.left = tmp;
				else prev.right = tmp;
				tmp.left = cur.left;
				tmp.right = cur.right;
        	}
        }else{
        	if(prev.left == cur) prev.left = cur.left;
      		else prev.right = cur.left;
        }
        return res.left;
    }
}