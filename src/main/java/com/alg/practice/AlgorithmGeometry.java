package com.alg.practice;

public class AlgorithmGeometry {

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * p1p2 == p2p3 == p3p4 == p4p1
     *
     * @param points
     * @return
     */
    public static boolean isSquare(Point[] points) {
        int p1p2 = distance(points[0], points[1]);
        int p2p3 = distance(points[1], points[2]);
        int p3p4 = distance(points[2], points[3]);
        int p4p1 = distance(points[3], points[0]);

        return (p1p2 ^ p2p3 & p1p2 ^ p3p4 & p1p2 ^ p4p1) == 0;
    }

    private static int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) {
        //[0,0],[0,1],[1,1],[1,0]
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0) };
        System.out.println(isSquare(points));

        //[[0,0],[0,1],[1,1],[10,0]]
        points = new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(10, 0) };
        System.out.println(isSquare(points));
    }

}
