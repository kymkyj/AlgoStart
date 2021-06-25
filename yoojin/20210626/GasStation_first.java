package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

최소 가격 위치 찾고, 그 가격 앞부분에서 다시 최소가격 위치찾고
이진탐색트리 처럼 하면 되겠다.

왜안되지ㅜ
long~~~~~~~~~~
 */

public class GasStation_first {

    static class gast{
        long cost;
        int index;

        public gast(long cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[]distance = new long [n-1];
        long[]cost = new long [n];
        long sum=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        gast g = findMinCost(n,cost);
        int idx = g.index;
        long mcost = g.cost;
        int end = n-1;
        while(idx>=0){
            for(int i=idx; i<end; i++){
                sum += mcost*distance[i];
            }
            System.out.println(sum);
            g= findMinCost(idx,cost);
            end = idx;
            idx =g.index;
            mcost=g.cost;
        }

        System.out.print(sum);
    }

    static public gast findMinCost(int end, long[]cost){
        long mincost =Long.MAX_VALUE;
        int idx =-1;

        for(int i=0; i<end; i++){
            if(mincost>cost[i]){
                idx =i;
                mincost =cost[i];
            }
        }
        System.out.println(idx+" "+mincost);
        return new gast(mincost,idx);
    }
}


