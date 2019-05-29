package com.alg.practice;

import java.util.*;

import static com.alg.practice.MyDataStructure.*;

public class AlgorithmTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minVal, int maxVal) {
        if (root == null) return true;
        return !(root.val >= maxVal || root.val <= minVal)
                && isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
    }

    public static void printInOrderTravasal(TreeNode a) {
        if(a == null) {
            return;
        }

        System.out.print(a.val + " ");

        printInOrderTravasal(a.left);
        printInOrderTravasal(a.right);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        treePath(root, new StringBuilder(), paths);
        return paths;
    }

    private static void treePath(TreeNode root, StringBuilder str, List<String> paths) {
        if(root == null) {
            return;
        }

        if(str.length() != 0) {
            str.append("->");
        }

        str.append(root.val);
        String temp = str.toString();

        if(root.left == null && root.right == null) {
            paths.add(str.toString());
            return;
        }

        treePath(root.left, str, paths);
        str = new StringBuilder(temp);
        treePath(root.right, str, paths);
    }

    public static TreeNode treeToDoublyList(TreeNode root) {
        return treeToList(root, null, null);
    }

    private static TreeNode treeToList(TreeNode root, TreeNode prev, TreeNode head) {
        if(root.left == null && root.right == null) {
            root.right = prev;
            prev.left = root;
            return head == null ? root : head;
        }

        TreeNode head1 = treeToList(root.left, root, head);
        head1 = treeToList(root.right, root.left, head1);

        return head1;
    }

    public static void assignIds(FBTreeNode n, int startIndex) {
        if(n == null) {
            return;
        }

        n.id = startIndex;

        if(n.children != null) {
            for(FBTreeNode n1 : n.children) {
                assignIds(n1, ++startIndex);
                startIndex = n1.children != null ? startIndex + n1.children.size() : startIndex;
            }
        }
    }

    public static void printIdsAndName(FBTreeNode n) {
        if(n == null) {
            return;
        }

        System.out.println(n.id + ", " + n.name);

        if(n.children != null) {
            for(FBTreeNode n1 : n.children) {
                printIdsAndName(n1);
            }
        }
    }

    public static String toString(int i) {
        if(i == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while(i > 0) {
            sb.insert(0, i % 10);
            i /= 10;
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(3, null, null);
        TreeNode n2 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(2, n2, n1);
        TreeNode n4 = new TreeNode(5, null, null);
        TreeNode n5 = new TreeNode(4, n3, n4);

        //TreeNode root = treeToDoublyList(n5);

        //printInOrderTravasal(root);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(2)) {
                iterator.remove();
            }
        }

        for(Integer i : list) {
            System.out.println(i);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()) {
            if(iterator1.next().getKey().equals("b")) {
                iterator1.remove();
            }
        }

        for(String s : map.keySet()) {
            System.out.println(s);
        }

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());

        Person person = new Person("ashwin", "ravindran");
        Person person1 = new Person("brijesh", "ashwin");

        Comparator<Person> comparator = (p1, p2) -> {
            int c1 = p1.lastName.compareTo(p2.lastName);

            if(c1 != 0) {
                return c1;
            }

            return p1.firstName.compareTo(p2.firstName);
        };

        List<Person> list1 = new ArrayList<>();
        list1.add(person);
        list1.add(person1);

        Collections.sort(list1, comparator);

        for(Person p : list1) {
            System.out.println(p.firstName + " " + p.lastName);
        }

        FBTreeNode FBTreeNode = new FBTreeNode("D", null);
        FBTreeNode FBTreeNode1 = new FBTreeNode("E", null);
        FBTreeNode FBTreeNode2 = new FBTreeNode("F", null);

        List<FBTreeNode> bChildren = new ArrayList<>();
        bChildren.add(FBTreeNode);
        bChildren.add(FBTreeNode1);
        bChildren.add(FBTreeNode2);

        FBTreeNode FBTreeNode3 = new FBTreeNode("B", bChildren);
        FBTreeNode FBTreeNode4 = new FBTreeNode("C", null);

        List<FBTreeNode> aChildren = new ArrayList<>();
        aChildren.add(FBTreeNode3);
        aChildren.add(FBTreeNode4);

        FBTreeNode FBTreeNode5 = new FBTreeNode("A", aChildren);

        assignIds(FBTreeNode5, 0);

        printIdsAndName(FBTreeNode5);

        System.out.println(toString(1234));
    }

}
