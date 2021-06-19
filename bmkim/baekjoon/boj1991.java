package study.baekjoon;

import apple.laf.JRSUIUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj1991 {
    Node root;
    static int N;
    public static void main(String[] args) throws IOException {
        //[백준] 트리 순회
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i=0; i<N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);

    }

    static class Tree {
        Node root;

        public void createNode(char data, char leftData, char rightData) {
            if (root == null) {
                root = new Node(data);
                if (leftData != '.') {
                    root.lt = new Node(leftData);
                }
                if (rightData != '.') {
                    root.rt = new Node(rightData);
                }
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        public void searchNode(Node root, char data, char leftData, char rightData) {
            if (root == null) {
                return;
            } else if (root.data == data) {
                if (leftData != '.') {
                    root.lt = new Node(leftData);
                }
                if (rightData != '.') {
                    root.rt = new Node(rightData);
                }
            } else {
                searchNode(root.lt, data, leftData, rightData);
                searchNode(root.rt, data, leftData, rightData);
            }
        }

        public void preorder(Node root) {
            System.out.print(root.data);
            if (root.lt != null) {
                preorder(root.lt);
            }
            if (root.rt != null) {
                preorder(root.rt);
            }
        }

        public void inorder(Node root) {
            if (root.lt != null) {
                inorder(root.lt);
            }
            System.out.print(root.data);
            if (root.rt != null) {
                inorder(root.rt);
            }
        }

        public void postorder(Node root) {
            if (root.lt != null) {
                postorder(root.lt);
            }
            if (root.rt != null) {
                postorder(root.rt);
            }
            System.out.print(root.data);
        }
    }
}

class Node {
    char data;
    Node lt, rt;
    public Node(char value) {
        this.data = value;
    }
}
