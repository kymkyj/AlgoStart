package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class kakao_howmany_make_toy_with_robots_20210904 {
    static ArrayList<ArrayList<Integer>> combi = new ArrayList<>(); //총 필요한 부품의 종류 중에 살 수 있는 부품의 개수를 통한 조합리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] needs = {{1,0,0},{1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}};
        int r = 2;

        System.out.println(solution(needs,r));

    }
    public static int solution(int[][]needs,int r){
        int col = needs[0].length;
        int row = needs.length;
        int max=0;
        HashSet<Integer> typelist= new HashSet<>(); //구매해야 하는 총 부품의 종류
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();  //각 장난감 품목별 필요한 부품의 종류 입력할 list

        for(int i=0; i<row ; i++){
            list.add(new ArrayList<>());
            for(int j=0; j<col; j++){
                if(j>i) break;  //내 번호보다 큰 부품은 필요 없음
                if(needs[i][j] ==1){
                    if(!typelist.contains(j)) { //필요 부품리스트에 존재하지 않을 때 추가
                        typelist.add(j);
                    }
                    list.get(i).add(j); //해당 장난감 품목에 필요한 부품 추가
                }
            }
        }

        Integer[] robottype = typelist.toArray(new Integer[typelist.size()]);   //list로 굳이 변환하지 않아도 될거 같긴함.
        boolean [] visited = new boolean[robottype.length]; //조합을 위한 방문처리 함수

        combination(robottype,visited,r,0);

        //만들어진 조합으로 만들 수 있는 장난감 갯수 세기
        for(ArrayList<Integer> robot :combi){   //로봇의 종류
            boolean flag =true;
            int cnt =0;
            for(ArrayList<Integer> toy: list ){ //장난감
                for(int a: toy){    //장난감에 필요한 부품
                    System.out.print(a);
                    if(!robot.contains(a)){ //현재 구매한 로봇으로 만들 수 없다면 break;
                        flag =false;
                        break;
                    }
                }
                if(flag){cnt++;}
                else flag =true;
            }
            if(cnt>max) max =cnt;
        }

        return max;
    }

    public static void combination(Integer[]robottype, boolean[] visited, int cnt, int start){
        //조합으로 구매가능한 부품 로봇 뽑기
        if (cnt == 0) {     //필요한 부품 수를 다 뽑았다면 combi 리스트에 넣어주기
            inputcombi(robottype, visited);
            return;
        }

        for (int i = start; i < robottype.length; i++) {
            visited[i] = true;
            combination(robottype, visited, cnt-1 ,i+1);
            visited[i] = false;
        }
    }
    public static void inputcombi(Integer[]robottype, boolean[]visited){
       ArrayList<Integer> al = new ArrayList<>();
       //true 처리된 값을 넣어주기
        for(int i=0; i<visited.length; i++){
            if(visited[i]){
                al.add(robottype[i]);
            }
        }
        combi.add(al);

    }
}