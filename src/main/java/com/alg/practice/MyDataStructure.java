package com.alg.practice;

public class MyDataStructure {

    public static class Node {
        public int val;
        public Node next;

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static class MaxNode {
        public int val;
        public int max;
        public MaxNode next;

        public MaxNode(int val, MaxNode node) {
            this.val = val;
            this.next = node;
            max = node != null && node.val > val ? node.val : val;
        }
    }

    public static class MaxStack {
        private MaxNode top;

        public void push(int i) {
            top = new MaxNode(i , top);
        }

        public int pop() {
            if(top == null) {
                return -1;
            }

            int val = top.val;
            top = top.next;

            return val;
        }

        public int max() {
            if(top == null) {
                return -1;
            }

            return top.max;
        }
    }

}
