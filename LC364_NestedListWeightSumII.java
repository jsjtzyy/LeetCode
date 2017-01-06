import java.util.*;
/*
	use the BFS to traverse all the nestedList
*/
public class LC364_NestedListWeightSumII{
	public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> cur = new LinkedList<>();
        int res = 0, depth = 1, tmp = 0;
        Stack<Integer> stack = new Stack<>();
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                tmp += ni.getInteger();
            }else{
                cur.offer(ni.getList());
            }
        }
        stack.push(tmp);
        List<NestedInteger> list = null;
        Queue<List<NestedInteger>> next = null;
        while(!cur.isEmpty()){
            next = new LinkedList<>();
            tmp = 0;
            while(!cur.isEmpty()){
                list = cur.poll();
                for(NestedInteger ni : list){
                    if(ni.isInteger()){
                        tmp += ni.getInteger();
                    }else{
                        next.offer(ni.getList());
                    }
                }
            }
            stack.push(tmp);
            cur = next;
        }
        while(!stack.isEmpty()){
            res += stack.pop() * depth;
            ++depth;
        }
        return res;
    }
}

/*
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
*/