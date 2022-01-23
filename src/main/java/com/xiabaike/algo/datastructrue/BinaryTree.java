package com.xiabaike.algo.datastructrue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author xiabaike
 * @Date 2019/4/17 23:03
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    // 前序遍历
    public void preTraverse() {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() != 0) {
            if(node != null) {
                stack.push(node);
                System.out.println(node.getValue());
                node = node.getLeft();
            }else{
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    // 中序遍历
    public void inTraverse() {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() != 0) {
            if(node != null) {
                stack.push(node);
                node = node.getLeft();
            }else{
                node = stack.pop();
                System.out.println(node.getValue());
                node = node.getRight();
            }
        }
    }

    // 后序遍历
    public void postTraverse() {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || stack.size() != 0) {
            if(node != null) {
                stack.push(node);
                node = node.getLeft();
            }else{
                node = stack.pop();
                node = node.getRight();
                System.out.println(node.getValue());
            }
        }
    }

    // 层次遍历
    public void levelTraverse() {
        Queue<Node> queue = new LinkedList();
        Node node = root;
        queue.offer(node);
        while (queue != null && queue.size() != 0) {
            node = queue.poll();
            System.out.println(node.getValue());
            if(node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        Node node10=new Node(10,null,null);
        Node node8=new Node(8,null,null);
        Node node9=new Node(9,null,node10);
        Node node4=new Node(4,null,null);
        Node node5=new Node(5,node8,node9);
        Node node6=new Node(6,null,null);
        Node node7=new Node(7,null,null);
        Node node2=new Node(2,node4,node5);
        Node node3=new Node(3,node6,node7);
        Node node1=new Node(1,node2,node3);

        BinaryTree tree = new BinaryTree(node1);
        tree.levelTraverse();
    }

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
