package com.alg.practice;

public class AlgorithmBit {

    public static int count1InBinary(int x) {
        int sum = 0;

        while(x > 0) {
            sum += x & 1;
            x >>= 1;
        }

        return sum;
    }

    /**
     * https://www.youtube.com/watch?v=uDqUb50Bmvs&index=15&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj
     *
     * @param x
     * @param N
     * @return
     */
    public static int circularShift(int x, int N) {
        return (x >> N | x << (32 - N));
    }

    public static void main(String args[]) {
        System.out.println(count1InBinary(5));
    }

}
