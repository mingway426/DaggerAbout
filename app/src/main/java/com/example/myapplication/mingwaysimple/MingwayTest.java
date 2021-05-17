package com.example.myapplication.mingwaysimple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MingwayTest {
    public static int findAnswer(String args) {
        int length = args.length();
        int res = 0;
        int start=0,end = 0;
        String result = "";
        Set<Character> hashset = new HashSet<>();
        while (start<length && end < length) {
            if (hashset.contains(args.charAt(end))) {
                hashset.remove(args.charAt(start++));
            }else {
                hashset.add(args.charAt(end++));
                res = Math.max(res, end -start);
                String temp = args.substring(start,end);
                result = temp.length()>result.length()?temp:result;
            }
        }

        System.out.println("reslut  = " + result);
        return res;
    }
    public static void main(String[] args) {
        String test = "gjgijj1jj244hhjajj2hrfsafsfasfa";
        int reslut = MingwayTest.findAnswer(test);
        System.out.println("result length= " + reslut);
    }
}
