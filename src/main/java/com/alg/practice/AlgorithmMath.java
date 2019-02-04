package com.alg.practice;

public class AlgorithmMath {

    public static int minCoin(int x, int[] coins) {
        int num = 0;
        int i = 0;

        while(x > 0 && i < coins.length) {
            if(x - coins[i] >= 0) {
                x -= coins[i];
                num++;
            } else {
                i++;
            }
        }

        return num;
    }

    public static void printLongTOTime(long s) {
        long hr = s / (3600 * 1000);
        long min = (s / 3600 * 1000 * 60) % 60;
        long sec = (s / (3600 * 60 * 1000)) % 1000;

        System.out.println(hr);
        System.out.println(min);
        System.out.println(sec);
    }

}
