import java.util.*

public class LC156_BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode res = null, node = null;
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(tmp != null){
        	stack.push(tmp);
        	tmp = tmp.left;
        }
        res = stack.pop();
        node = res;
        while(!stack.isEmpty()){
        	tmp = stack.pop();
        	node.right = tmp;
        	if(tmp.right != null) 
        		node.left = tmp.right;
        	else 
        		node.left = null;   // pay attention to add null to the empty leaf !!!
        	node = node.right;
        }
        node.left = null;
        node.right = null;
        return res;
    }
}