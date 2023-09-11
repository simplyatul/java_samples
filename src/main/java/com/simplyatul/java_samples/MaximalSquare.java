package com.simplyatul.java_samples;

import java.util.Arrays;

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150
 * https://www.youtube.com/watch?v=MMr19RE7KYY&t=710s
 * 
 * Top Down Approach
 * maximalSquareInt
 * maximalSquareIntMem => Recursion with Memoization
 *
 * Bottom Up Approach
 * maximalSquareIntTabuler (w/ Memoization)
 */

public class MaximalSquare 
{
    public static int max = 0;
    public static int maximalSquareChar(int n, int m, char[][] matrix) {

        if(n>= matrix.length || m>= matrix[0].length)
            return 0;
        
        int right = maximalSquareChar(n, m+1, matrix);
        int diagonal = maximalSquareChar(n+1, m+1, matrix);
        int down = maximalSquareChar(n+1, m, matrix);
        
        if(matrix[n][m] == '1') {
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(ans, max);
            return ans;
        } else {
            return 0;
        }
    }

    public static int maximalSquareInt(int n, int m, int[][] matrix) {
        if(n>= matrix.length || m>= matrix[0].length)
            return 0;
        
        int right = maximalSquareInt(n, m+1, matrix);
        int diagonal = maximalSquareInt(n+1, m+1, matrix);
        int down = maximalSquareInt(n+1, m, matrix);
        
        if(matrix[n][m] == 1) {
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(ans, max);
            return ans;
        } else {
            return 0;
        }
    }
    
    public static int maximalSquareIntMem(int n, int m, int[][] matrix, int [][]dp) {
        if(n>= matrix.length || m>= matrix[0].length)
            return 0;
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        int right = maximalSquareIntMem(n, m+1, matrix, dp);
        int diagonal = maximalSquareIntMem(n+1, m+1, matrix, dp);
        int down = maximalSquareIntMem(n+1, m, matrix,dp);
        
        if(matrix[n][m] == 1) {
            dp[n][m] = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(dp[n][m], max);
            return dp[n][m];
        } else {
            return 0;
        }

    }


    public static int maximalSquareIntTabuler(int[][] matrix) {
        int cols, rows = matrix.length;
        if (rows > 0) {
            cols = matrix[0].length; 
        } else {
            cols = 0;
        }

        int [][] dp = new int [rows+1][cols+1];
        for(int []r: dp) {
            Arrays.fill(r, 0);
        }

        for(int i=rows-1; i>=0; --i) {
            for(int j=cols-1; j>=0; --j) {

                int right = dp[i][j+1]; 
                int diagonal = dp[i+1][j+1];
                int down = dp[i+1][j]; 

                if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return 0;
    }

    public static void main( String[] args )
    {
        int[][] i = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        
        int[][] i1 = {
                {1, 1},
                {1, 1}
        };
        
        int[][] i3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };

        int [][] i4 = {
                {0}
        };
        
        int [][] i5 = {};
        
        int [][] target = i3;
        int [][] dp = new int [target.length][target[0].length];
        for(int [] row: dp) {
            Arrays.fill(row, -1);
        }
        maximalSquareInt(0,0,target);
        System.out.println("maximalSquareInt: " + max); max = 0; 
        
        maximalSquareIntMem(0,0,target, dp);
        System.out.println("maximalSquareIntMem: " + max); max = 0;
        
        maximalSquareIntTabuler(target);
        System.out.println("maximalSquareIntTabuler: " + max); max = 0;

//        char[][] c = {
//                {'1', '1', '1'},
//                {'1', '0', '1'},
//                {'1', '1', '1'}
//        };
//
//        char[][] c3 = {
//                {'1', '1', '1'},
//                {'1', '1', '1'},
//                {'1', '1', '1'}
//        };
//
//        char [][] c4 = {
//                {'0'}
//        };
//        
//        maximalSquareChar(0, 0, c);
//        System.out.println("maximalSquareChar: " + max);


        
    }
}
