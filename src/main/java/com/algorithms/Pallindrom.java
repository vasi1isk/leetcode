package com.algorithms;

public class Pallindrom {

    public int countPalindromicSubsequence(String s) {
        if (s.length() < 3) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Pallindrom pallindrom = new Pallindrom();
        String s = "abc";
        int result = pallindrom.countPalindromicSubsequence(s);
        System.out.println("Result: " + result);
    }
}