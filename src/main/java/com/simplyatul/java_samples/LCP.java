package com.simplyatul.java_samples;

public class LCP {
    public static String longestCommonPrefix(String[] S) {
        if (S.length == 0) return "";
        String prefix = S[0];
        for (int i = 1; i < S.length; i++)
            while (S[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) 
                    return "";
            }        
        return prefix;
    }

    public static void main(String args[]) {
        // Your code goes here
        String s[] = {"flow", "flower", "flight"};
        //String s[] = {"Gler", "Aer", "fer"};
        System.out.println(longestCommonPrefix(s));
        System.out.printf("Index %d\n", "flow".indexOf("fl"));
    }
}