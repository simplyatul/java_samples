package com.simplyatul.java_samples;

import java.util.*;

/**
 * Refs: 
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * https://walkccc.me/LeetCode/problems/0023/
 *
 * ToDo: Do this in C++
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode l: lists) {
            if(l != null) {
                minHeap.offer(l);
            }
        }

        while(!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            if(n != null && n.next != null) {
                minHeap.offer(n.next);
            }
            if(n != null) {
                curr.next = n;
                curr = n;
            }
        }
        return dummy.next;
    }

    public ListNode[] createListOfList() {
        ListNode[] lists = new ListNode[3];
        
        SLL s1 = new SLL();
        s1.addNode(new ListNode(12));
        s1.addNode(new ListNode(11));
        s1.addNode(new ListNode(10));

        SLL s2 = new SLL();
        s2.addNode(new ListNode(99));
        s2.addNode(new ListNode(9));
        s2.addNode(new ListNode(1));
        s2.addNode(new ListNode(-1));
        s2.addNode(new ListNode(-98));
        
        lists[0] = s1.getHead();
        lists[1] = s2.getHead();

        SLL s3 = new SLL();
        s3.addNode(new ListNode(50));
        s3.addNode(new ListNode(25));
        s3.addNode(new ListNode(-2));

        lists[2] = s3.getHead();
        
        return lists;
    }
    public static void main(String[] args) {
        MergeKSortedLists sortedList = new MergeKSortedLists();
        ListNode[] lists = sortedList.createListOfList();
        ListNode head = sortedList.mergeKLists(lists);

        
        System.out.println("Merged List");
        ListNode h = head;
        while(h != null) {
            System.out.printf("%d ", h.val);
            h = h.next;
        }
        System.out.println();
    }
}
