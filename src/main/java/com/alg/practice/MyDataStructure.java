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

    //TODO: Finish off the stack problem
    public static class Stacks {
        int[] tops;
        int[] stackData;
        int[] nextIndex;
        int nextAvailable;

        public Stacks(int stackNum, int capacity) {
            tops = new int[stackNum];
            stackData = new int[capacity];
            nextIndex = new int[stackNum];

            for(int i = 0; i < nextIndex.length; i++) {
                nextIndex[i] = i + 1;
            }

            nextIndex[capacity - 1] = -1;
            nextAvailable = -1;
        }

        public void push(int stackNum, int value) {
            stackData[nextAvailable] = value;
            nextAvailable = nextIndex[nextAvailable];
        }

    }

}
