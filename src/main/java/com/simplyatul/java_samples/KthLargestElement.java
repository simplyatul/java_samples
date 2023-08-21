package com.simplyatul.java_samples;

import java.util.*;

/*
 * Ref: https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150
 * 
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
    	// Comparator.reverseOrder() - requires java 1.8 or more
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: nums) {
            maxHeap.add(i);
        }
        while(k-1>0) {
            maxHeap.remove();
            k--;
        }
        return maxHeap.peek();
    }
    
    public static void main(String args[]) {
        //int[] nums = {1,3,3,4};
        //int[] nums = {3,2,1,5,6,4}; // k = 2. Ans = 5
        int[] nums = {3,2,3,1,2,4,5,5,6}; // k = 4. Ans = 4
        KthLargestElement kth = new KthLargestElement();
        System.out.println(kth.findKthLargest(nums, 4));
    }
}