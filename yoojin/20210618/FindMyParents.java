package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindMyParents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] result = new int [n+1];
        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        for(int i=0; i<n+1; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        StringTokenizer st;
        int first, second;
        for(int i=0; i<n-1; i++){
             st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second =Integer.parseInt(st.nextToken());
            adjList[first].add(second);
            adjList[second].add(first);
        }

        bfs(1,adjList,result);

        for(int i=1; i<result.length; i++){
            System.out.print(result[i]);
        }

    }
    public  static void bfs (int v, LinkedList<Integer>[] adjlist, int[]result){
        Queue<Integer> queue = new LinkedList<Integer>();
        result[v] =v;
        queue.add(v);

        while(queue.size() !=0){
            int c = queue.poll();

            Iterator<Integer> iter = adjlist[c].iterator();

            while(iter.hasNext()){
                int k = iter.next();
                if(result[k] ==0){
                    result[k] =c;
                    queue.add(k);
                }
            }
        }
    }
}



