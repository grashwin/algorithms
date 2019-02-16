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

    public static long power(int number, int power) {
        int temp = 1;

        while(power > 0) {
            temp *= number;
            power--;
        }

        return temp;
    }
    
    public static void rotateMatrixClockWise(int[][] a) {
        int n = a.length - 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                swap(i, j, j, n-i, a);
                swap(i, j, n-j , i, a);
                swap(n-j , i, n-i, n-j, a);
            }
        }
    }

    public static void swap(int x1, int y1, int x2, int y2, int[][] a) {
        a[x1][y1] = a[x1][y1] + a[x2][y2];
        a[x2][y2] = a[x1][y1] - a[x2][y2];
        a[x1][y1] = a[x1][y1] - a[x2][y2];
    }

    public static void main(String args[]) {
        System.out.println(power(27, 3));
        System.out.println(1.0/power(27, 3));

        int[][] a = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},
                {13,14,15,16}};
        rotateMatrixClockWise(a);

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }

            System.out.println("");
        }
    }
}
