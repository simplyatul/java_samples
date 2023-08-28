package com.simplyatul.java_samples;

public class SLL {
    ListNode head;

    SLL() {
        head = null;
    }

    public ListNode getHead() {
        return head;
    }

    public void printList() {
        ListNode h = this.head;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
    
    public void addNode(ListNode node) {
        node.next = head;
        head = node;
    }
}
