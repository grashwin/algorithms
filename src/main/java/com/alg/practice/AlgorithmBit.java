package com.alg.practice;

public class AlgorithmBit {

    public static int count1InBinary(int x) {
        int sum = 0;

        while(x > 0) {
            sum += x ^ 1;
            x >>= 1;
        }

        return sum;
    }
}
