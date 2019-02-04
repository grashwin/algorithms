package com.alg.practice;

public class AlgorithmTree {

    public static boolean isBinaryTree(MyDataStructure.TreeNode a) {
        if(a == null || (a.left == null && a.right == null)) {
            return true;
        }

        return a.val >= a.left.val && a.val < a.right.val
                && isBinaryTree(a.left) && isBinaryTree(a.right);
    }

}
