import java.util.*;

public class LC369_PlusOneLinkedList{
	/*
	 Considering several cases: 
	 (1) number = 9999...9 where number is larger than Integer.MAX_VALUE
	 (2) number = 19 where MSB is not 9
	 (3) number = 10 where LSB is not 9
	 Use stack to store all previous nodes.
	*/
	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
        if(head == null) return dummy.next;
        int carry = 0;
        dummy.next = head;
        ListNode tmp = head;
        Stack<ListNode> stack = new Stack<>();
        while(tmp != null){
        	stack.push(tmp);
        	tmp = tmp.next;
        }
        tmp = stack.pop();
        if(tmp.val < 9){
        	tmp.val++;
        	return dummy.next;
        }
        while(!stack.isEmpty() && tmp.val == 9){
        	tmp.val = 0;
        	carry = 1;
        	tmp = stack.pop();
        }
        if(tmp.val != 9){
        	tmp.val += carry;
        }else{
        	tmp.val = 0;
        	ListNode node = new ListNode(1);
        	node.next = tmp;
        	dummy.next = node;
        }
        return dummy.next;
	}

	public ListNode generateList(int[] arr){
		ListNode head = null, tmp = null;
		if(arr == null || arr.length == 0) return head;
		head = new ListNode(arr[0]);
		tmp = head;
		for(int i = 1; i < arr.length; ++i){
			tmp.next = new ListNode(arr[i]);
			tmp = tmp.next;
		}
		return head;
	}
}