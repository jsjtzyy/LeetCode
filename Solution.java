import java.util.*;

public class Solution{
	public static void main(String[] args){
		LC366_FindLeavesOfBinaryTree lc = new LC366_FindLeavesOfBinaryTree();
		String tree = "1 2 3 4 5 null 6";
		TreeNode root = generateTree(tree);
		List<List<Integer>> res = lc.findLeaves2(root);
		for(List<Integer> list : res){
			for(Integer num : list){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		//System.out.println("test");
	}

	public static TreeNode generateTree(String str){
		if(str == null || str.length() == 0) return null;
		String[] words = str.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(words[0]));
		Queue<TreeNode> cur = new LinkedList<>();
		cur.add(root);
		int index = 1;
		TreeNode tmp = null;
		while(!cur.isEmpty()){
			Queue<TreeNode> next = new LinkedList<>();
			while(!cur.isEmpty()){
				tmp = cur.poll();
				if(index < words.length && !words[index].equals("null")){
					tmp.left = new TreeNode(Integer.parseInt(words[index]));
					next.add(tmp.left);
				}
				++index;
				if(index < words.length && !words[index].equals("null")){
					tmp.right = new TreeNode(Integer.parseInt(words[index]));
					next.add(tmp.right);
				}
				++index;				
			}
			cur = next;
		}
		return root;
	}
}