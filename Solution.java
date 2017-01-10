import java.util.*;

public class Solution{
	public static void main(String[] args){
		LC254_FactorCombinations sl = new LC254_FactorCombinations();
		List<List<Integer>> res = sl.getFactors(12);
		//System.out.println(res.size());
		for(List<Integer> list : res){
			for(Integer num : list){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		//System.out.println(sl.findMaxForm(array, m, n));
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

	public static void printTree(TreeNode root){
		String res = null;
		if(root == null) System.out.println("null");
		Queue<TreeNode> cur = new LinkedList<>();
		cur.offer(root);
		TreeNode tmp = null;
		Queue<TreeNode> next = null;
		StringBuilder sb = null;
		while(!cur.isEmpty()){
			next = new LinkedList<>();
			sb = new StringBuilder();
			while(!cur.isEmpty()){
				tmp = cur.poll();
				sb.append(tmp.val + " ");
			}
		}
	}
}