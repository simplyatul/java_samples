package com.simplyatul.java_samples;

import java.util.*;

/*
 * Ref: https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an integer array nums, return true if any value 
 * appears at least twice in the array, and return false if every 
 * element is distinct.
 * 
 * Input: nums = [1,2,3,1]
    Output: true
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class ContainesDuplicatePI {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (final int i: nums) {
            if(false == seen.add(i))
                return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int[] nums = {1,3,3,4};
        ContainesDuplicatePI cd = new ContainesDuplicatePI();
        System.out.println(cd.containsDuplicate(nums));
    }
}