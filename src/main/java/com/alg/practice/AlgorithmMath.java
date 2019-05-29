package com.alg.practice;

import java.util.*;

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


    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size() -1;

        for(int i = n; i >= 0; i--) {
            int j = A.get(i) + 1;

            if(j < 10) {
                A.set(i, j);
                return A;
            }

            A.set(i, 0);
        }

        A.add(0, 1);

        return A;
    }

    /**
     * Sliding window problem
     *
     * @param a
     * @return
     */
    public static int maxSubArray(int[] a) {
        int cSum = a[0];
        int sum = a[0];

        for(int i = 1; i < a.length; i++) {
            int j = a[i];
            cSum = Math.max(j, j + cSum);
            sum = Math.max(cSum, sum);
        }

        return sum;
    }

    public static String largestNumber(int[] a) {
        Arrays.sort(a);

        List<Long> results = new ArrayList<>();

        for(int i = 0; i < a.length; i++) {
            String s = "" + a[i];

            for(int j = 0; j < a.length; j++) {
                if(i != j) {
                    s += a[j];
                }
            }

            results.add(Long.parseLong(s));
        }

        Long max = 0L;

        for(Long i : results) {
            if(i > max) {
                max = i;
            }
        }

        return max.toString();
    }

    public static ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 2; i < a; i++) {
            if(isPrime(i) && isPrime(a - i)) {
                result.add(i);
                result.add(a - i);
                break;
            }
        }

        return result;
    }

    private static boolean isPrime(int a) {
        for(int i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(largestNumber(new int[] {3, 30, 34, 5, 9}));
//        System.out.println(power(27, 3));
//        System.out.println(1.0/power(27, 3));
//
//        int[][] a = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},
//                {13,14,15,16}};
//        rotateMatrixClockWise(a);
//
//        for(int i = 0; i < a.length; i++) {
//            for(int j = 0; j < a.length; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//
//            System.out.println("");
//        }
//
//        //2, 5, 6, 8, 6, 1, 2, 4, 5
//        ArrayList<Integer> A = new ArrayList<>();
//        A.add(2);
//        A.add(5);
//        A.add(6);
//        A.add(8);
//        A.add(6);
//        A.add(1);
//        A.add(2);
//        A.add(4);
//        A.add(5);
//
//        for(int i : plusOne(A)) {
//             System.out.println(i);
//        }

//        System.out.println(maxSubArray(new int[]{-307, -316, -236, -136, -323, -370, -386})); // -1 -3 + 4 - 1 + 2 + 1 -5 + 4
//
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // -1 -3 + 4 - 1 + 2 + 1 -5 + 4
//
//        System.out.println(maxSubArray(new int[] {-120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138,
//                -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53, -488, -327,
//                -182, -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194,
//                -140, -278, -65, -38, -144, -407, -235, -426, -219, 62, -299, 1, -454, -247, -146, 24, 2, -59, -389,
//                -77, -19, -311, 18, -442, -186, -334, 41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365,
//                -249, -454, -226, -473, 91, -412, -30, -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215,
//                -102, -63, 80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463, -212, -267, -302,
//                -471, -245, -165, 43, -288, -379, -243, 35, -288, 62, 23, -444, -91, -24, -110, -28, -305, -81, -169, -348,
//                -184, 79, -262, 13, -459, -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60, 35,
//                -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267, -270, -432, -272, -26, -327,
//                -409, -353, -475, -210, -14, -145, -164, -300, -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402,
//                -241, 67, -334, -452, -367, -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415,
//                -273, -200, -146, -437, -457, 75, 84, -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157,
//                82, -450, 86, -478, -58, 9, -500, -87, 29, -286, -378, -466, 88, -366, -425, -38, -134, -184, 32, -13, -263,
//                -371, -246, 33, -41, -192, -14, -311, -478, -374, -186, -353, -334, -265, -169, -418, 63, 77, 77,
//                -197, -211, -276, -190, -68, -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329, 40,
//                -341, -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83, -185, -140, -62,
//                -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2, 81, -326, -339, -56, -123, 10,
//                -463, 41, -458, -409, -314, -125, -495, -256, -388, 75, 40, -37, -449, -485, -487, -376, -262, 57,
//                -321, -364, -246, -330, -36, -473, -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293, -298,
//                -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163, -28, -210, -18,
//                -484, 45, 10, 79, -441, -197, -16, -145, -422, -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151,
//                -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25, -361, -88, -241,
//                -225, -367, -440, -200, 38, -248, -429, -284, -23, 19, -220, -105, -81, -269, -488, -204, -28, -138, 39,
//                -389, 40, -263, -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67,
//                -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49, -150, -37, -493, -284,
//                -107, 93, -183, -60, -261, -310, -380}));
    }
}
