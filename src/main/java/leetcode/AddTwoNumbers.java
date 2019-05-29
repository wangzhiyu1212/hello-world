package leetcode;
/**
 *     	ListNode l1 = new ListNode(2);
    	l1.next = new ListNode(4);
    	l1.next.next = new ListNode(3);
    	ListNode l2 = new ListNode(5);
    	l2.next = new ListNode(6);
    	l2.next.next = new ListNode(4);
    	l2.next.next.next = new ListNode(2);
    	AddTwoNumbers a = new AddTwoNumbers();
    	ListNode l = a.addTwoNumbers(l1, l2);
    	while (l!=null) {
    		System.out.println(l.val);
    		l = l.next;
    	}
 * @author wangl
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(0);
		ListNode q = p;
		ListNode a=l1, b=l2;
		int carry = 0;
		int x,y;
		while(a!=null||b!=null) {
			x = (a==null)? 0:a.val;
			y = (b==null)? 0:b.val;
			p.val = (x + y + carry)%10;
			carry = (x + y + carry)/10;
			a = (a==null)? a:a.next;
			b = (b==null)? b:b.next;
			if(carry > 0 || a!=null || b!= null) {
				p.next = new ListNode(carry);
			}
			p = p.next;
		}
		
		return q;
	}
}
