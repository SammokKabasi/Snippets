package com.leetcode.oddevenlinkedlist;

public class Solution {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode headEven = new ListNode(0);
		ListNode even = headEven;
		ListNode headOdd = new ListNode(0);
		ListNode odd = headOdd;
		ListNode node = head;
		while (node != null) {
			odd.next = node;
			odd = odd.next;
			node = node.next;
			if (node != null) {
				even.next = node;
				even = even.next;
				node = node.next;
			}
		}
		odd.next = headEven.next;
		return headOdd;
	}
}