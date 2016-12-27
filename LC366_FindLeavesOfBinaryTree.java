import java.util.*;
/*
	method1: topological sort
    method2: use the height of each node to detetmine when should be deleted.
*/
public class LC366_FindLeavesOfBinaryTree{
    /*
       ------------- method1 -------------------------
    */
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
        Node node = new Node(null, root.val);
        Queue<Node> queue = new LinkedList<>();
        if(root.left != null){
        	node.outDegree++;
        	traverse(node, root.left, queue);
        }
        if(root.right != null){
        	node.outDegree++;
        	traverse(node, root.right, queue);
        }
        if(node.outDegree == 0) queue.offer(node);

        Node tmp = null;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
        	Queue<Node> next = new LinkedList<>();
        	while(!queue.isEmpty()){
        		tmp = queue.poll();
        		list.add(tmp.val);
        		if(tmp.father != null && --tmp.father.outDegree == 0) next.offer(tmp.father);
        	}
        	res.add(list);
        	list = new ArrayList<>();
        	queue = next;
        }
        return res;
    }

    public void traverse(Node father, TreeNode child, Queue<Node> queue){
    	Node node = new Node(father, child.val);
        if(child.left != null){
        	node.outDegree++;
        	traverse(node, child.left, queue);
        }
        if(child.right != null){
        	node.outDegree++;
        	traverse(node, child.right, queue);
        }
        if(node.outDegree == 0) queue.offer(node);
    }

    class Node implements Comparable<Node>{
		int outDegree;
		Node father;
		int val;
		public Node(Node father, int val){
			this.father = father;
			outDegree = 0; 
			this.val = val;
		}
		@Override
		public int compareTo(Node that){
			return this.outDegree - that.outDegree;
		}
	}
    /*
        ------------- method2 -------------------------
    */
    public List<List<Integer>> findLeaves2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new TreeMap<>(); // O(nlogn)
        int height = 1 + Math.max(Helper(root.left, map), Helper(root.right, map)); 
        List<Integer> list = null;
        if(map.containsKey(height)){
            list = map.get(height);
        }else{
            list = new ArrayList<>();
        }
        list.add(root.val);
        map.put(height, list);
        for(Integer num : map.keySet()){
            res.add(map.get(num));
        }
        return res;
    }

    public int Helper(TreeNode node, Map<Integer, List<Integer>> map){
        if(node == null) return 0;
        int height = 1 + Math.max(Helper(node.left, map), Helper(node.right, map)); 
        List<Integer> list = null;
        if(map.containsKey(height)){
            list = map.get(height);
        }else{
            list = new ArrayList<>();
        }
        list.add(node.val);
        map.put(height, list);
        return height;
    }
}



