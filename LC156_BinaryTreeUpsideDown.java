import java.util.*

public class LC156_BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode res = null;
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(tmp != null){
        	stack.push(tmp);
        	tmp = tmp.left;
        }
        res = stack.pop();
        
        if(!stack.isEmpty())
    }
}