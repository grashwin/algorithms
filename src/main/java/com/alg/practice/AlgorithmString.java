package com.alg.practice;

import java.util.*;

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

    public static Set<String> permutation(String s) {
        Set<String> result = new HashSet<>();
        perm(0, s, result);

        return result;
    }

    private static void perm(int index, String s, Set<String> result) {
        if(index == s.length()) {
            return;
        }

        char c = s.charAt(index);
        String prefix = s.substring(0,index);
        String suffix = s.substring(index + 1);
        String temp = prefix + suffix;

        for(int i = 0; i < temp.length(); i++) {
            prefix = temp.substring(0, i) + c;
            suffix = temp.substring(i);
            result.add(prefix + suffix);
        }

        result.add(temp + c);

        perm(index + 1, s, result);
    }

    private static int computeDistance(String s1, String s2) {
        int diff = Math.abs(s1.length() - s2.length());
        int[] text = new int[256];

        for(int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            text[c] = text[c] + 1;
        }

        for(int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);

            if(text[c] > 0) {
                text[c] = text[c] - 1;
            } else {
                diff++;
            }
        }

        return diff;
    }

    private static String replaceSpaces(String s1) {
        boolean insertSpace = false;
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            if(c == ' ') {
                insertSpace = true;
            } else if(insertSpace) {
                str.append("%20").append(c);
                insertSpace = false;
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    public static List<String> combination(String s1, String s2) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            for(int j = 0; j < s2.length(); j++) {
                result.add("" + c + s2.charAt(j));
            }
        }

        return result;
    }

    public static List<String> getWords(Set<String> words, String word) {
        List<String> result = new ArrayList<>();

        if(words.isEmpty() || word.isEmpty()) {
            return result;
        }

        getWords(words, word, result);

        return result;
    }

    public static void getWords(Set<String> words, String word, List<String> result) {
        if(word == null || word.isEmpty()) {
            return;
        }

        if(words.contains(word)) {
            result.add(word);
            return;
        }

        StringBuilder str = new StringBuilder();
        int i = 0;

        for(; i < word.length(); i++) {
            String temp = str.toString();

            if(words.contains(str.toString())) {
                result.add(temp);
                break;
            }

            str.append(word.charAt(i));
        }

        int index = i == word.length() ? 1 : i;

        if(index < word.length()) {
            getWords(words, word.substring(index), result);
        }
    }

    public static void main(String args[]) {
        Set<String> words = new HashSet<>();

        words.add("jump");
        words.add("jumpedov");
        words.add("jumped");
        words.add("over");
        words.add("some");
        words.add("thing");
        words.add("something");

        List<String> cache = getWords(words, "jumpedoversomething");

        for(String s: cache) {
            System.out.println(s);
        }
    }
}
