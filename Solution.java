import java.util.*;

public class Solution{
	public static void main(String[] args){
		LC247_StrobogrammaticNumberII sl = new LC247_StrobogrammaticNumberII();
		List<String> res = sl.findStrobogrammatic(4);
		Map<Integer, Character> map = new TreeMap<>();
		map.put(2, 'c');
		map.put(1, 'd');
		map.put(3, 'w');
		map.put(4,'s');
		for(Integer num : map.keySet()){
			System.out.println(num);
		}
		System.out.println();
		map.remove(1);
		for(Integer num : map.keySet()){
			System.out.println(num);
		}
		//System.out.println(res.size());
		//for(String str : res){
			//System.out.println(str);
		//}
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