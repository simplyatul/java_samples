package com.simplyatul.java_samples;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public void printList() {
        while(this.next != null) {
            System.out.println(this.val);
        }
    }
    
}
