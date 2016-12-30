import java.util.*;

public class Solution{
	public static void main(String[] args){
		LC280_WiggleSort ws = new LC280_WiggleSort();
		int[] nums = {3, 5, 2, 1, 6, 3};
		ws.wiggleSort2(nums);
		for(int i = 0; i < nums.length; ++i){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	/*
		Method to generate binary tree from String
		Format: "1 2 3 null 4 null 5"
				  1
			  2      3
		  null 4  null 5
	*/
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