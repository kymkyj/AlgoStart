package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
1941
 */

public class MST_1197 {
    static ArrayList<edge> lists =new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e =Integer.parseInt(st.nextToken());

        for(int i=0; i<e; i++){
            st =new StringTokenizer(br.readLine());
            lists.add(new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        //간선 정보 오름차순
        Collections.sort(lists);
        int [] parents =new int [v+1];

        //부모노드 초기화
        for(int i=1; i<=v; i++){
            parents[i] =i;
        }

        int sum=0;
        for(edge edge:lists){
            if(!UnionFind.findParent(parents,edge.v1,edge.v2)){
                sum +=edge.cost;
                UnionFind.unionParent(parents,edge.v1,edge.v2);
            }
        }

    }
}

class edge implements Comparable<edge> {
    int v1;
    int v2;
    int cost;
    public edge(int v1,int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        if(this.cost<o.cost) return -1;
        else if (this.cost ==o.cost) return 0;
        else return 1;
    }
}

class UnionFind {
    public static int getParent(int[] parent, int x) {
        if(parent[x]==x)return x;
        return parent[x] =getParent(parent,parent[x]);
    }

    public static void unionParent(int []parent, int x,int y){
        x =getParent(parent,x);
        y = getParent(parent,y);

        if(x<y) parent[y]=x;
        else parent[x]=y;
    }

    public static boolean findParent(int [] parent, int x,int y){
        x=getParent(parent,x);
        y=getParent(parent,y);
        if(x==y) return true;
        else return false;
    }
}