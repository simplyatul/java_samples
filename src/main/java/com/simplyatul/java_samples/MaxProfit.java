package com.simplyatul.java_samples;

public class MaxProfit {
    static int maxProfit(int prices[], int n)
    {
        int buy = prices[0], max_profit = 0;
        for (int i = 1; i < n; i++) {
            System.out.printf("buy: %d, max_profit: %d\n", buy, max_profit);
            // Checking for lower buy value
            if (buy > prices[i])
                buy = prices[i];
 
            // Checking for higher profit
            else if (prices[i] - buy > max_profit)
                max_profit = prices[i] - buy;
        }
        return max_profit;
    }
    
    public static void main( String[] args )
    {
        int prices[] = { 7, 1, 5, 6, 4 };
        int n = prices.length;
        int max_profit = maxProfit(prices, n);
        System.out.println(max_profit);
    }
}
