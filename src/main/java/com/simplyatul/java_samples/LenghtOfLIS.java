package com.simplyatul.java_samples;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-interview-150
 *
 *
 */
public class LenghtOfLIS 
{
    
    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if(1 == nums.length) {
            return 1;
        }

        if(2 == nums.length) {
            if (nums[0] < nums[1]) return 2;
            if (nums[0] == nums[1]) return 1;
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        dp[nums.length-1] = 1;
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                dp[i] = 1 + dp[i+1]; 
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    public static void main( String[] args )
    {
        int [] N1 = {5, 10, 1, -1};
        int [] N2 = {10, 9, 2, 5, 3, 7, 101, 18};
        int [] N3 = {1, 3, -1};
        int [] N4 = {1};
        int [] N5 = {};
        int [] N6 = {4,10,4,3,8,9}; // 
        System.out.println("Longest increasing subsequence: " + lengthOfLIS(N6));
    }
}
