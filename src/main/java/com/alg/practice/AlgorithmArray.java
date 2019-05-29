package com.alg.practice;

import java.util.*;

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

    public static int repeatedNumber(final int[] a) {
        Set<Integer> cache = new HashSet<>();
        int n = a.length;

        for (int i = 1; i < n; i += 2) {
            if (cache.contains(a[i])) {
                return a[i];
            }

            cache.add(a[i]);
        }

        for (int i = 0; i < n; i += 2) {
            if (cache.contains(a[i])) {
                return a[i];
            }
        }

        return -1;
    }

    public static int maximumGap(int[] a) {
        int n = a.length;

        int[] lMins = new int[n];
        int[] rMaxs = new int[n];

        for(int i = 0; i < n; i++) {
           lMins[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++) {
            rMaxs[i] = Integer.MIN_VALUE;
        }

        lMins[0] = a[0];
        rMaxs[n - 1] = a[n - 1];

        for(int i = 1; i < n; i++) {
            lMins[i] = Math.min(a[i], lMins[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--) {
            rMaxs[i] = Math.max(a[i], rMaxs[i + 1]);
        }

        int i = 0;
        int j = 0;
        int maxGap = -1;

        while(i < n && j < n) {
            if(lMins[i] < rMaxs[j]) {
                maxGap = Math.max(maxGap, Math.abs(j - i));
                j++;
            } else {
                i++;
            }
        }

        return maxGap;
    }

    public static int nobleInteger(Integer[] a) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));

        Collections.sort(list);
        int n = list.size() - 1;

        if(list.get(n) == 0) {
            return 1;
        }

        for(int i = 0; i < list.size() - 1; i++) {
            int v1 = list.get(i);
            int v2 = list.get(i + 1);

            if(v1 >= 0 && v1 != v2 && v1 == n - i) {
                return 1;
            }
        }

        return -1;
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int a) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        results.add(result);

        for(int i = 1; i < a; i++) {
            List<Integer> list = results.get(i - 1);
            result = new ArrayList<>();
            result.add(list.get(0));

            for(int j = 1; j < list.size(); j++) {
                int p = list.get(j - 1);
                int c = list.get(j);

                result.add(p + c);
            }

            result.add(list.get(list.size() - 1));
            results.add(result);
        }

        return results;
    }

    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    // for n boards and k partitions
    static int partition(int arr[], int n, int k)
    {
        // base cases
        if (k == 1) // one partition
            return sum(arr, 0, n - 1);
        if (n == 1)  // one board
            return arr[0];

        int best = Integer.MAX_VALUE;

        // find minimum of all possible maximum
        // k-1 partitions to the left of arr[i],
        // with i elements, put k-1 th divider
        // between arr[i-1] & arr[i] to get k-th
        // partition
        for (int i = 1; i <= n; i++)
            best = Math.min(best, Math.max(partition(arr, i, k - 1),
                    sum(arr, i, n - 1)));

        return best;
    }

    public static int paint(int a, int b, Integer[] array) {
        List<Integer> c = Arrays.asList(array);

        int cmax = 0;
        int max = 0;
        int u = c.size() / a;
        int r = c.size() % a;
        boolean useR = r > 0;

        for(int i = 0; i < c.size(); i++) {
            int v1 = c.get(i);

            if(u > 0) {
                cmax += v1 * b;
                u--;
            } else if(useR) {
                cmax += v1 * b;
                useR = false;
                r--;
            }else {
                max = Math.max(max, cmax);
                cmax = v1 * b;
                u = (c.size() / a) - 1;
                useR = r > 0;
            }
        }

        return Math.max(max, cmax) % 10000003;
    }

    public static int paint1(int a, int b, Integer[] array) {
        List<Integer> c = Arrays.asList(array);
        Collections.sort(c);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < c.size(); i++) {
            for(int j = 0; j < a && i + j < c.size(); j++) {
                min = Math.min(min, b * c.get(i + j));
            }

            max = Math.max(max, min);
            min = Integer.MAX_VALUE;
        }

        return max;
    }

    /**
     * [1, 2, 3, 4, 5]
     *
     * @param a
     * @param x
     */
    public static int binarySearch(int[] a , int l, int r, int x) {
        if(r < l) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if(a[mid] == x) {
            return mid;
        }

        if(x < a[mid]) {
            return binarySearch(a, l, mid - 1, x);
        }

        return binarySearch(a, mid + 1, r, x);
    }

    public static int rotatedArraySearch(int[] a, int x) {
        int pivot = findPivot(a);

        if(pivot == -1) {
            return binarySearch(a, 0, a.length - 1, x);
        }

        if(x > a[pivot]) {
            return -1;
        }

        if(a[pivot] == x) {
            return pivot;
        }

        if(x >= a[0]) {
            return binarySearch(a, 0, pivot, x);
        }

        return binarySearch(a, pivot + 1, a.length - 1, x);
    }

    public static int findPivot(int[] a) {
        int i = 0;
        int j = (int) Math.sqrt(a.length);
        boolean found = false;

        while(i < a.length && j < a.length) {
            if(a[i] > a[j]) {
                found = true;
                break;
            }

            i = j;
            j += Math.sqrt(a.length);
        }

        if(!found) {
            return -1;
        }

        for(int k = i; k < j; k++) {
            if(a[k] > a[k + 1]) {
                return k;
            }
        }

        return j;
    }

    public static int first(int arr[], int low, int high, int x)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x);
            else
                return first(arr, low, (mid -1), x);
        }
        return -1;
    }

    public static int last(int arr[], int low, int high, int x, int n)
    {
        if (high >= low)
        {
            int mid = low + (high - low)/2;
            if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid -1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static ArrayList<Integer> findRange(int[] a, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(first(a, 0, a.length - 1, x));
        list.add(last(a, 0, a.length - 1, x, a.length));

        return list;
    }

    public static void main(String args[]) {
//        int[] a = new int[] {6, 2, 1, 8, 3};
//
//        int[] b = twoSumOfSortedArray(a, 4);
//
//        int[] c = threeSumOfSortedArray(a, 11);
//
//        for(int i : c) {
//            System.out.println(i);
//        }
//
//        List<int[]> list = permutation(a);
//
//        for(int[] r : list) {
//            for (int i : r) {
//                System.out.print(i);
//            }
//
//            System.out.print("\n");
//        }

//        System.out.println(paint1(3, 10, new Integer[] {640, 435, 647, 352, 8, 90, 960, 329, 859}));
//        System.out.println(paint1(5, 10, new Integer[] {658, 786, 531, 47, 169, 397, 914}));
//        System.out.println(pascalTriangle(5));
        //System.out.println(binarySearch(new int[] {1, 2, 3, 4, 5}, 0, 4, 100));
//        System.out.println(rotatedArraySearch(new int[] {194, 195, 196, 197, 198, 199, 201, 203, 204, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 42, 43, 44, 45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 57, 58, 59, 60, 61, 63, 65, 66, 68, 69, 70, 71, 73, 74, 76, 77, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 91, 92, 93, 94, 95, 97, 98, 99, 101, 103, 104, 105, 106, 107, 108, 109, 110, 113, 114, 115, 117, 118, 120, 121, 122, 123, 124, 127, 128, 130, 131, 133, 134, 135, 136, 137, 139, 140, 141, 142, 143, 144, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 158, 159, 160, 161, 162, 163, 164, 166, 167, 169, 170, 171, 172, 174, 175, 177, 178, 179, 181, 182, 184, 185, 187, 189, 190, 192, 193}, 1));
//        System.out.println(rotatedArraySearch(new int[] {1, 2, 3, 4, 5}, 1));
        //System.out.println(nobleInteger(new Integer[] {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5}));


//        ArrayList<Integer> result = findRange(new int[] {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 8);
//
//        for(Integer i : result) {
//            System.out.println(i);
//        }
    }
}
