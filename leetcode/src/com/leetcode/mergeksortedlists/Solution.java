package com.leetcode.mergeksortedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		Comparator<ListNode> comparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		};
		PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
		// add everythign to the priority queue
		for (ListNode list : lists) {
			if (list != null) {
				queue.add(list);
			}
		}

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return head.next;

	}

	public static void main(String[] args) {
		ListNode listnode = new ListNode(0);
		listnode.next = new ListNode(2);
		listnode.next.next = new ListNode(5);
		ListNode[] lists = new ListNode[1];
		lists[0] = listnode;
		ListNode res = new Solution().mergeKLists(lists);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}