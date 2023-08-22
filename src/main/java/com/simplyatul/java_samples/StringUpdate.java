package com.simplyatul.java_samples;

/**
 * A string is given consisting of letters A, B, C and D chars only. 
 * String can be transformed by replacing a letter A together with an adjacent letter B and vice-a-versa
 * Same transformation can be applied with C and D
 * Apply the above transformations.
 * If no transformation can be applied further, then return the String as is
 *
 */
public class StringUpdate {

    public final static String T1 = "AB";
    public final static String T2 = "BA";
    public final static String T3 = "CD";
    public final static String T4 = "DC";

    public static Boolean replaceIfy(StringBuilder S, String replaceWith) {
        int index = S.indexOf(replaceWith);
        if (index != -1) {
            S.delete(index, index+replaceWith.length());
            return true;
        }

        return false;
    }
    public static String solution1(String S) {
        StringBuilder str = new StringBuilder();
        str.append(S);
        while(false == str.isEmpty()) {

            if (replaceIfy(str, T1)) continue;
            if (replaceIfy(str, T2)) continue;
            if (replaceIfy(str, T3)) continue;
            if (replaceIfy(str, T4)) continue;
            break;
        }
        
        return str.toString();
    }
    public static String solution(String S) {
        String input = new String(S);
        while (false == input.isEmpty()) {
            String n = input.replace(T1, "");
            if (false == n.equals(input)) {
                input = n;
                continue;
            }

            n = input.replace(T2, "");
            if (false == n.equals(input)) {
                input = n;
                continue;
            }

            n = input.replace(T3, "");
            if (false == n.equals(input)) {
                input = n;
                continue;
            }

            n = input.replace(T4, "");
            if (false == n.equals(input)) {
                input = n;
                continue;
            }

            break;
        }
        return input;
    }

    public static void main(String[] args) {
        String i = "DDDDAAACC";
        System.out.printf("Sol: %s\n", solution1(i));

    }

}
