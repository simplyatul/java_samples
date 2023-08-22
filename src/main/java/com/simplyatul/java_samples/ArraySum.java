package com.simplyatul.java_samples;


public class ArraySum 
{
    public static int Sum(int k, int n, int[] A) {
        int sum=0;
        for (int i = k; i<=n; i++) {
            sum=sum+A[i];
        }
        return sum;
    }

    /*
     * Return the total number of fair indexes
     * fair index k is such all following sums are equal
     * sum(A[0]+..+A[k-1])
     * sum(A[k]+..+A[n-1])
     * sum(B[0]+..+B[k-1])
     * sum(B[k]+..+B[n-1])
     */
    public static int solution(int[] A, int[] B) {

        int fairIndexes = 0;
        int k = 1;
        int n = A.length;
        int ALeftSum = Sum(0, k-1, A);
        int ARightSum = Sum(k, n-1, A);
        int BLeftSum = Sum(0, k-1, B);
        int BRightSum = Sum(k, n-1, B);
        
        while (k <= n - 1) {
            if (    ALeftSum == ARightSum
                &&  BLeftSum == BRightSum 
                &&  ALeftSum == BLeftSum) {
                fairIndexes++;
            }
            ALeftSum += A[k];
            ARightSum -= A[k];

            BLeftSum += B[k];
            BRightSum -= B[k];
            k++;
        }
        return fairIndexes;
    
    }
	
    public static void main( String[] args )
    {
        int[] A = {0,4,-1,0,3}; int[] B = {0,-2,5,0,3}; // fairIndexes = 2
        //int[] A = {3,2,6}; int[] B = {4,1,6};   // fairIndexes = 0
        //int[] A = {2,-2,-3,3}; int[] B = {0,0,4,-4};   // fairIndexes = 1
        System.out.printf("Sol: %d", solution(A, B));
    }
}
