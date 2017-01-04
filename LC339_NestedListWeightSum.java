import java.util.*;
import java.io.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


public class LC339_NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                res += ni.getInteger();
            }else{
                res += compute(ni.getList(), 2);
            }
        }
        return res;
    }

    // helper function
    public int compute(List<NestedInteger> nestedList, int depth){
        int res = 0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                res += ni.getInteger() * depth;
            }else{
                res += compute(ni.getList(), depth + 1);
            }
        }
        return res;
    }
}