package com.simplyatul.java_samples;

/**
 * 120. Triangle - https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=top-interview-150
 * https://www.youtube.com/watch?v=ynG6YV1wZ5o
 * Bottom-up approach
 *
 */

import java.util.*;
public class MinPathSumTriangle 
{

    public static int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size() <= 0) return 0;
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        for(int i = triangle.size()-2; i>=0; --i) {

            for(int j=0; j<triangle.get(i).size(); j++) {
                Integer min = Math.min(
                        triangle.get(i+1).get(j), 
                        triangle.get(i+1).get(j+1));

                triangle.get(i).set(j, triangle.get(i).get(j)+min);
                
            }
            
        }
        return triangle.get(0).get(0);
    }
    public static void main( String[] args )
    {
        List<Integer> r1 = Arrays.asList(2);
        List<Integer> r2 = Arrays.asList(3,4);
        List<Integer> r3 = Arrays.asList(6,5,7);
        List<Integer> r4 = Arrays.asList(4,1,8,3);
        
        /*
         * Creates immutable Lists
         * List<Integer> r22 = Stream.of(3,4).collect(Collectors.toList());// Java 8
         * List<Integer> r33 = List.of(6,5,7); // Java 9
         * List<Integer> r44 = List.of(4,1,8,3); // Java 9
         */

        
        List<List<Integer>> LofL2 = Arrays.asList(r1,r2);
        List<List<Integer>> LofL4 = Arrays.asList(r1,r2,r3,r4);
        System.out.printf("Min Sum path: %d", minimumTotal(LofL4));
    }
}
