package com.alg.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmArray {

    public static List<int[]> permutation(int[] a) {
        List<int[]> result = new ArrayList<>();
        perm(0, a, result);

        return result;
    }

    private static void perm(int index, int[] a, List<int[]> result) {
        if(index / a.length == a.length) {
            return;
        }

        int correctIndex = index % a.length;

        if(correctIndex != a.length - 1) {
            result.add(a.clone());
            swap(correctIndex, a);
        }

        perm(index + 1, a, result);
    }

    private static void swap(int index, int[] a) {
        a[index] = a[index] + a[index + 1];
        a[index + 1] = a[index] - a[index + 1];
        a[index] = a[index] - a[index + 1];
    }

    public static int[] twoSumOfSortedArray(int[] a, int sum) {
        int[] result = new int[2];

        int first = 0;
        int second = 1;

        while(first < a.length && second < a.length) {
            if(first == second) {
              second++;
            } else if(a[first] + a[second] == sum) {
                result[0] = a[first];
                result[1] = a[second];
                break;
            } else if(a[first] + a[second] > sum) {
                first++;
            } else if(a[first] + a[second] < sum) {
                second++;
            }
        }

        return result;
    }

    public static int[] threeSumOfSortedArray(int[] a, int sum) {
        Set<Integer> cache = new HashSet<>();
        for(int i : a) {
            cache.add(i);
        }

        int[] result = new int[3];
        int first = 0;
        int second = 1;

        while(first < a.length && second < a.length) {
            int diff = sum - (a[first] + a[second]);

            if(first == second) {
                second++;
            } else if(cache.contains(diff)) {
                result[0] = a[first];
                result[1] = a[second];
                result[2] = diff;
                break;
            } else if(diff > a[first]) {
                first++;
            } else if(diff < a[first]) {
                second++;
            }
        }

        return result;
    }

    public static List<int[]> combination(int[] a) {
        return null;
    }



    public static void main(String args[]) {
        int[] a = new int[] {6, 2, 1, 8, 3};

        int[] b = twoSumOfSortedArray(a, 4);

        int[] c = threeSumOfSortedArray(a, 11);

        for(int i : c) {
            System.out.println(i);
        }

        List<int[]> list = permutation(a);

        for(int[] r : list) {
            for (int i : r) {
                System.out.print(i);
            }

            System.out.print("\n");
        }
    }

}
