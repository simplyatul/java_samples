package com.simplyatul.java_samples;

import java.util.*;

/*
 * Ref: https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String orig: strs) {
            char arr[] = orig.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(hm.containsKey(s)) {
                hm.get(s).add(orig);
            } else {
                Vector<String> v = new Vector<String>();
                v.add(orig);
                hm.put(s, v);
            }
        }
        List<List<String>> gn = new ArrayList<List<String>>();
        
        for(Map.Entry<String, List<String>> element: hm.entrySet()) {
            gn.add(element.getValue());
        }
        return gn;

    }

    public static void main(String args[]) {
        //String s[] = {"eat","tea","tan","ate","nat","bat"};
        String s[] = {"a", "b"};
        List<List<String>> gn = groupAnagrams(s);
        for(List<String> l: gn) {
            System.out.println(l);
        }
    }
}