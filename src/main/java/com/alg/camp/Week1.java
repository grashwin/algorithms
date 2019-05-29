package com.alg.camp;

import java.util.*;

public class Week1 {

    public static String reverse(String s) {
        char[] a = s.toCharArray();

        int i = 0;
        int j = a.length - 1;

        while(i < j) {
            a[i] = (char) (a[i] + a[j]);
            a[j] = (char) (a[i] - a[j]);
            a[i] = (char) (a[i] - a[j]);

            i++;
            j--;
        }

        return new String(a);
    }

    public static String reverseSentence(String s) {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = a.length - 1; i >= 0; i--) {
            sb.append(a[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static List<Integer> findUnSortedArray(int a[]) {
        List<Integer> result = new ArrayList<>();

        int min = a.length - 1;
        int max = 0;

        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i + 1]) {
                min = Math.min(min, i);
                max = Math.max(max, i + 1);
            }
        }

        if(min == a.length - 1 && max == 0) {
            return result;
        }

        for(int i = 0; i < max; i++) {
            if(a[i] > a[min + 1] || a[i] > a[max]) {
                min = Math.min(min,i);
            }
        }

        for(int i = max; i < a.length; i++) {
            if(a[i] <= a[max]) {
                max = Math.max(max,i);
            }
        }

        for(int i = min; i <= max; i++) {
            result.add(a[i]);
        }

        return result;
    }

    //0,2,5,3,1,8,6,9
    public static List<Integer> findUnSortedArray1(int a[]) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int i = 0;
        int j = 1;

        while(i < a.length && j < a.length) {
            if(a[i] > a[j]) {
                start = Math.min(start, i);
                end = Math.max(end, j);
                i = i - 1 < 0 ? 0 : i - 1;
            } else {
                i = j;
                j++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int k = start; k <= end; k++) {
            result.add(a[k]);
        }

        return result;
    }

    public static int maxSubArray(int[] a) {
        int maxSoFar = a[0], maxEndingHere = a[0];

        for (int i = 1; i < a.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + a[i], a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }


    public static int numberOfTimesSubArraySum(int[] a, int x) {
        int count = 0;

        for(int i = 0; i < a.length; i++) {
            int sum = a[i];

            if(sum == x) {
                count++;
            }

            for(int j = i + 1; j < a.length; j++) {
                sum += a[j];

                if(sum == x) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int numberOfTimesSubArraySum1(int[] a, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int i : a) {
            sum += i;
            count += map.getOrDefault(sum - x, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void sortColors(int[] a, int k) {
        int low = 0, mid = 0;
        int high = a.length - 1;

        while(mid <= high) {
            if(a[mid] < k) {
                swap(a, low++, mid++);
            } else if(a[mid] == k) {
                mid++;
            } else if(a[mid] > k) {
                swap(a, mid, high--);
            }
        }
    }

    public static void sortColors(int[] a) {
        int low = 0, mid = 0;
        int high = a.length - 1;

        while(mid <= high) {
            if(a[mid] == 0) {
                swap(a, low++, mid++);
            } else if(a[mid] == 1) {
                mid++;
            } else if(a[mid] == 2) {
                swap(a, mid, high--);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        if(i == j) {
            return;
        }

        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    public static int[] searchRange(int[] a, int x) {
        int[] r = new int[2];

        r[0] = first(a, 0, a.length - 1, x);
        r[1] = last(a, 0, a.length - 1, x);

        return r;
    }

    public static int bs(int a[], int l, int h, int x) {
        if(l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;

        if(a[mid] == x) {
            return mid;
        }

        if(x < a[mid]) {
            return bs(a, l, mid - 1, x);
        }

        return bs(a, mid + 1, h, x);
    }

    public static int closest(int a[], int l, int h, int x, int diff) {
        if(l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;
        int newDiff = Math.abs(a[mid] - x);
        int r = a[mid];

        if(x < a[mid] && newDiff <= diff) {
            int left = closest(a, l, mid - 1, x, newDiff);
            r = left == -1 ? r : left;
        } else if(x > a[mid] && newDiff <= diff) {
            int right = closest(a, mid + 1, h, x, newDiff);
            r = right == -1 ? r : right;
        }

        return r;
    }

    public static int searchInsert(int[] a, int l, int h, int x) {
        if(l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;
        int r = mid;

        if(x < a[mid]) {
            int left = searchInsert(a, l, mid - 1, x);
            r = left == -1 ? mid - 1: left;
            r = r == -1 ? 0 : r;
            r = a[r] < x ? r + 1 : r;
        } else if(x > a[mid]){
            int right = searchInsert(a, mid + 1, h, x);
            r = right == -1 ? mid + 1: right;
        }

        return r;
    }

    public static int first(int[] a, int l, int h, int x) {
        if(l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;

        if(a[mid] == x && (mid == 0 || a[mid - 1] != x)) {
            return mid;
        }

        if(x <= a[mid]) {
            return first(a, l, mid - 1, x);
        }

        return first(a, mid + 1, h, x);
    }

    public static int last(int[] a, int l, int h, int x) {
        if(l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;

        if(a[mid] == x && (mid == a.length - 1 || a[mid + 1] != x)) {
            return mid;
        }

        if(x < a[mid]) {
            return last(a, l, mid - 1, x);
        }

        return last(a, mid + 1, h, x);
    }

    private static int rotatedSearch(int[] a, int x) {
        int p = pivot(a, 0, a.length);

        if(p == -1) {
            return bs(a, 0, a.length - 1, x);
        }

        if(a[p] == x) {
            return p;
        }

        int r = bs(a, 0, p - 1, x);

        if(r == -1) {
            r = bs(a, p + 1, a.length - 1, x);
        }

        return r;
    }

    private static int pivot(int[] a, int l, int h) {
        if(l >= h) {
            return -1;
        }

        int mid = l + (h - l) / 2;

        if(mid > 0 && a[mid] < a[mid - 1]) {
            return mid;
        }

        if(a.length > mid + 1 && a[mid] > a[mid + 1]) {
            return mid + 1;
        }

        if(a[l] >= a[mid]) {
            return pivot(a, l, mid - 1);
        }

        return pivot(a, mid + 1, h);
    }

    private static int peak(int[] a, int l, int h) {
        int mid = l + (h - l) / 2;

        if((mid == 0 || a[mid] > a[mid - 1])
                && (mid == a.length - 1 || a[mid] > a[mid + 1])) {
            return mid;
        }

        if(mid > 0 && a[mid - 1] > a[mid]) {
            return peak(a, l, mid - 1);
        }

        return peak(a, mid + 1, h);
    }

    private static int squareRoot(int x, int l, int h) {
        int mid = l + (h - l) / 2;

        long r = mid * mid;

        if(r == x) {
            return mid;
        }

        if(mid == l || mid == h) {
            if(r < x) {
                long r1 = (mid + 1) * (mid + 1);
                return r1 > x ? mid : mid + 1;
            } else {
                long r1 = (mid - 1) * (mid - 1);
                return r1 > x ? mid : mid - 1;
            }
        }

        if(x < mid || x < r) {
            return squareRoot(x, l, mid - 1);
        }

        return squareRoot(x, mid + 1, h);
    }

    private static List<Integer> test(int[] a, Set<Integer> set) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //1,2,2,5,6,3,1,2
        for(int i = 0; i < a.length; i++) {
            if(set.contains(a[i])) {
                int v = !map.containsKey(a[i]) ? i : Math.max(map.get(a[i]), i);
                map.put(a[i], v);
            }
        }

        if(map.size() != set.size()) {
            return new ArrayList<>();
        }

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int k : map.keySet()) {
            start = Math.min(start, map.get(k));
            end = Math.max(end, map.get(k));
        }

        List<Integer> list = new ArrayList<>();

        for(int i = start; i <= end; i++) {
            list.add(a[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        //System.out.println(reverseSentence("i live in a house"));
//        List<Integer> results = findUnSortedArray(new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
//        List<Integer> results = findUnSortedArray(new int[] {1, 3, 2, 3, 3});
//
//        for(Integer i : results) {
//            System.out.println(i);
//        }

        int[] a = new int[]{2, 6, 4, 8, 10, 9, 15};

//        int[] r = searchRange(a, 1);
//
//        for(int i : r) {
//            System.out.println(i);
//        }

        //System.out.println(bs(a, 0, 0, 4));
        //System.out.println(squareRoot(2147395599, 1, 2147395599));

//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);

        List<Integer> r = findUnSortedArray1(a);

        for(int i : r) {
            System.out.println(i);
        }
    }

}
