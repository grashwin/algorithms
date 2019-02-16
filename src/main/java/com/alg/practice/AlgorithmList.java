package com.alg.practice;

import java.util.Stack;

import static com.alg.practice.MyDataStructure.*;

public class AlgorithmList {

    public static Node splitList(Node a) {
        Node head = a;
        int size = 0;

        while(a != null) {
            a = a.next;
            size++;
        }

        a = head;
        Node result = null;
        int mid = size / 2;
        int i = 0;

        while(i < mid) {
            if(i == mid - 1) {
                result = a.next;
                a.next = null;
            }

            i++;
            a = a.next;
        }

        return result;
    }

    public static boolean isPalindrome(Node a) {
        Stack<Integer> stack = new Stack<>();

        Node head = a;

        int size = 0;

        while(a != null) {
            a = a.next;
            size++;
        }

        a = head;
        int mid = size / 2;
        int i = 0;

        while(i < mid) {
            stack.push(a.val);
            a = a.next;
            i++;
        }

        if(size % 2 != 0) {
            a = a.next;
        }

        while(a != null) {
            if(!stack.pop().equals(a.val)) {
                return false;
            }

            a = a.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Node a7 = new Node(1, null);
        Node a1 = new Node(2, a7);
        Node a2 = new Node(1, a1);
        Node a3 = new Node(3, a2);
        Node a4 = new Node(2, a3);
        Node a5 = new Node(1, a4);

        System.out.println(isPalindrome(a2));

        Node a6 = splitList(a5);
        Node temp = a5;

        System.out.println("List 1");

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println("List 2");
        temp = a6;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
