package com.practice.Practice.linkedlist;

import java.util.Stack;

public class MainClass {
	public static void main(String[] args) {
		// [1,2,4]
		// [1,3,4]
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode l21 = new ListNode(7);
		ListNode l22 = new ListNode(8);
		ListNode l23 = new ListNode(7);

		l21.next = l22;
		l22.next = l23;

		/*
		 * ListNode result = mergeTwoLists(l1, l21); ListNode result =
		 * removeElements(l21, 7); while (result != null) {
		 * System.out.println(result.val); result = result.next; }
		 * 
		 * ListNode result1 = getIntersectionNode(l1, l21); System.out.println(result1);
		 */
		// System.out.println(isPalindrome(l21));
//
//		ListNode result = middleNode(l1);
//		while (result != null) {
//			System.out.println(result.val);
//			result = result.next;
//		}

		//System.out.print(pairSum(l1));
		ListNode temp = addTwoNumbers(l1, l21);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	// 7654321
	//     787
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode();
		ListNode result = dummy;
		
		int carry =0;
		while (l1 != null || l2!=null) {
			int sum = 0;
			if(l1 == null) {
				sum = l2.val + carry;
				l2 = l2.next;
			} else if(l2 == null) {
				sum = l1.val + carry;
				l1 =l1.next;
			}else {
				sum = l1.val+ l2.val + carry;
				l1 =l1.next;
				l2 = l2.next;
			}
			carry =0;
			 
			if(sum>9) {
				carry = sum /10;
				int add = sum%10;
				ListNode temp = new ListNode(add);
				dummy.next = temp;
				dummy = dummy.next;
			}else {
				ListNode temp = new ListNode(sum);
				dummy.next = temp;
				dummy = dummy.next;
			}
		}
		if(carry != 0) {
			ListNode temp = new ListNode(carry);
			dummy.next = temp;
			dummy = dummy.next;
		}
		return result.next;
	}

	public static int pairSum(ListNode head) {

		int sum = 0;
		ListNode a = head;
		int lengthA = 0;
		Stack<Integer> st = new Stack<>();

		while (a != null) {
			lengthA++;
			a = a.next;
		}
		a = head;
		int temp = 0;
		while (a != null) {
			if (temp < lengthA / 2) {
				st.push(a.val);
				temp++;
				a = a.next;
			} else {
				int t = st.pop();
				if (t + a.val > sum)
					sum = a.val + t;
				a = a.next;
			}
		}

		return sum;
	}

	private static void reverseHalf(ListNode a, int lengthA) {
		int tempL = 1;
		while (tempL < lengthA / 2) {
			a = a.next;
			tempL++;
		}
		a.next = reverseList(a.next);
	}

	public static ListNode middleNode(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public static boolean isPalindrome(ListNode head) {

		ListNode a = head;
		int l = 0;
		while (a != null) {
			l++;
			a = a.next;
		}

		int mid = l / 2;

		int temp = 0;
		a = head;

		while (temp < mid) {
			temp++;
			a = a.next;
		}
		ListNode reverse = reverseList(a);

		a = head;

		while (reverse != null) {
			if (a.val != reverse.val)
				return false;
			else {
				a = a.next;
				reverse = reverse.next;
			}
		}

		return true;

	}

	public static ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(10, head);
		ListNode prev = dummy;
		ListNode a = head;

		while (a != null) {
			if (a.val == val) {
				prev.next = a.next;
				a = a.next;
			} else {
				prev = a;
				a = a.next;
			}
		}
		return dummy.next;
	}

	public static ListNode reverseList(ListNode head) {

		ListNode curr = head;
		ListNode next = null;

		ListNode prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		else {
			ListNode a = headA;
			ListNode b = headB;
			int lengthA = 0;
			int lengthB = 0;

			while (a != null) {
				lengthA++;
				a = a.next;
			}

			while (b != null) {
				lengthB++;
				b = b.next;

			}
			a = headA;
			b = headB;

			int diff = Math.abs(lengthA - lengthB);
			if (lengthA > lengthB) {
				int temp = 0;
				while (temp < diff) {
					a = a.next;
					temp++;
				}
			} else if (lengthB > lengthA) {
				int temp = 0;
				while (temp < diff) {
					b = b.next;
					temp++;
				}
			}

			while (a != null && b != null) {
				if (a == b)
					return a;
				else {
					a = a.next;
					b = b.next;
				}
			}
		}
		return null;
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		if (head.next == null)
			return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow.next != null && fast.next != null && fast.next.next != null) {

			if (slow == fast)
				return true;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return false;

	}

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode result = head;
		ListNode curr = head;

		while (curr != null && curr.next != null) {

			if (curr.next.val == curr.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return result;
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		ListNode result;
		ListNode curr;

		if (list1.val <= list2.val) {
			result = list1;
			curr = result;
			list1 = list1.next;
		} else {
			result = list2;
			curr = list2;
			list2 = list2.next;
		}

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
			} else {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			}
		}

		if (list1 != null) {
			curr.next = list1;
		}
		if (list2 != null) {
			curr.next = list2;
		}
		return result;
	}
}
