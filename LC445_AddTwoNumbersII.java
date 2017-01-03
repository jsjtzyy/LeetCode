import java.util.*;

public class LC445_AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode dummy = new ListNode(0);
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode tmp1  = l1, tmp2 = l2;
        while(tmp1 != null){
        	stack1.push(tmp1.val);
        	tmp1 = tmp1.next;
        } 
        while(tmp2 != null){
        	stack2.push(tmp2.val);
        	tmp2 = tmp2.next;
        }
        int val1 = 0, val2 = 0, sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
        	if(!stack1.isEmpty()){
        		val1 = stack1.pop();
        	}else{
        		val1 = 0;
        	}
        	if(!stack2.isEmpty()){
        		val2 = stack2.pop();
        	}else{
        		val2 = 0;
        	}
        	sum = val1 + val2 + carry;
        	carry = sum / 10;
        	tmp1 = new ListNode(sum % 10);
        	tmp1.next = tmp2;
        	tmp2 = tmp1;
        }
        if(carry != 0){
            tmp1 = new ListNode(carry);
            tmp1.next = tmp2;
            tmp2 = tmp1;
        }
        return tmp1;
    }
}