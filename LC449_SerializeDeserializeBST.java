import java.util.*;

public class LC449_SerializeDeserializeBST {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null) return null;
    	String res = String.valueOf(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        if(left != null) res = "(" + left + ")" + res;
        if(right != null) res = res + "(" + right + ")";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode res = null;
        if(data == null) return res;
        int len = data.length();
        int val = 0, index = 0;
        int leftCnt = 0;
        char ch = ' ';
        if(data.charAt(0) != '('){
        	//ch = data.charAt(index);
        	while(index < len && data.charAt(index) != '('){
        		val = val * 10 + (data.charAt(index) - '0');
        		++index;
        	}
        	res = new TreeNode(val);
        }else{
        	leftCnt = 1;
        	index = 1;
        	while(leftCnt != 0){
        		ch = data.charAt(index);
        		if(ch == '(') leftCnt++;
        		if(ch == ')') leftCnt--;
        		++index;
        	}
        	int leftPtr = index;
        	while(index < len && data.charAt(index) != '('){
        		val = val * 10 + (data.charAt(index) - '0');
        		++index;
        	}
        	res = new TreeNode(val);
        	res.left = deserialize(data.substring(1, leftPtr - 1));  // remove the outermost "(" and ")"
        }
        if(index != len) res.right = deserialize(data.substring(index + 1, len - 1));
        return res;
    }
}