package com.alg.practice;

import static com.alg.practice.MyDataStructure.*;

public class AlgorithmTree {

    public static boolean isBinaryTree(TreeNode a) {
        if(a == null || (a.left == null && a.right == null)) {
            return true;
        }

        return a.val >= a.left.val && a.val < a.right.val
                && isBinaryTree(a.left) && isBinaryTree(a.right);
    }

    public static void printInOrderTravasal(TreeNode a) {
        if(a == null) {
            return;
        }

        System.out.print(a.val + " ");

        printInOrderTravasal(a.left);
        printInOrderTravasal(a.right);
    }

    public static void main(String args[]) {
        TreeNode a = new TreeNode(4, null, null);
        TreeNode a1 = new TreeNode(5, null, null);
        TreeNode a2 = new TreeNode(6, null, null);
        TreeNode a3 = new TreeNode(7, null, null);

        TreeNode a4 = new TreeNode(3, a2, a3);
        TreeNode a5 = new TreeNode(2, a, a1);

        TreeNode a6 = new TreeNode(1, null, null);

        printInOrderTravasal(a6);
    }

}
