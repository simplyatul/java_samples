package com.simplyatul.java_samples;

/**
 * Ref: 
 * https://leetcode.com/problems/climbing-stairs/ - Problem #70
 * https://www.youtube.com/watch?v=97Esq1mqZGg
 *
 */

public class ClimbingStairs1 
{

    public static int climbStairs(int n) {
        if (n<=1)
            return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main( String[] args )
    {
        int n = 40;
        System.out.printf("Ways to Climb %d Stairs: %d", n, climbStairs(n));
    }
}
