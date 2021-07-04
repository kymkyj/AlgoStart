package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BiNode{
   char value;
   BiNode left;
   BiNode right;

   public BiNode(char value){
       this.value = value;
       left = null;
       right =null;
   }
   public char getValue(){
       return value;
   }
   public void setLeft(BiNode left){
       this.left =left;
   }
   public BiNode getLeft(){
       return left;
   }
    public void setRight(BiNode right){
        this.right =right;
    }
    public BiNode getRight(){
        return right;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BiNode [] nodes = new BiNode[n+1];
        for(int i =1; i<n+1; i++){
            nodes[i] = new BiNode((char)(64+i));
        }

        for(int i=0; i<n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
            int pn= st.nextToken().charAt(0)-0;
            int ln= st.nextToken().charAt(0)-0;
            int rn= st.nextToken().charAt(0)-0;

            if(ln != 46) nodes[pn-64].setLeft(nodes[ln-64]);
            if(rn != 46) nodes[pn-64].setRight(nodes[rn-64]);
        }

        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);

    }

    public static void preorder(BiNode ptr){
        if(ptr != null){
            System.out.print(ptr.getValue());
            preorder(ptr.getLeft());
            preorder(ptr.getRight());
        }
    }

    public  static void inorder(BiNode ptr){
        if(ptr !=null){
            inorder(ptr.getLeft());
            System.out.print(ptr.getValue());
            inorder(ptr.getRight());
        }
    }

    public  static  void  postorder(BiNode ptr){
        if(ptr !=null){
            postorder(ptr.getLeft());
            postorder(ptr.getRight());
            System.out.print(ptr.getValue());
        }
    }

}
