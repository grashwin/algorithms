package com.alg.practice;

import java.util.HashMap;

public class AlgorithmString {

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        boolean[] letters = new boolean[256];

        for(int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if(!letters[s2.charAt(i)]) {
                return false;
            }
        }

        return true;
    }

    public static String compression(String s1) {
        int count = 1;
        char c = s1.charAt(0);

        String result = "";

        for(int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) == c) {
                count++;
            } else {
                result = result + c + count;
                c = s1.charAt(i);
                count = 1;
            }
        }

        result = result + c + count;

        return result;
    }

    public static String kthMostFrequentString(String[] list, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : list) {
            if(map.containsKey(s)) {
                int count = map.get(s) + 1;
                map.put(s, count);
            } else {
                map.put(s, 1);
            }
        }

        return null;
    }

}
