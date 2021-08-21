package com.practice;

import java.util.*;

//타겟넘버
class TarketNumberSolution {
    public int solution(int[] numbers, int target) {
        return  dfs(numbers, target, 0,0);
    }
    public int dfs(int [] numbers,int target, int cur, int sum){
        int cnt = 0;
        if( numbers.length== cur){
            if( sum == target) {return 1;}

            return 0;
        }

        cnt+= dfs(numbers, target, cur+1, sum+numbers[cur]);
        cnt+= dfs(numbers, target, cur+1, sum-numbers[cur]);

        return cnt;
    }
}
//네트워크
class NetWorkSolution {
    public boolean [] checks;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        checks = new boolean [n];


        for(int i=0; i<n; i++){
            if(!checks[i]){
                answer++;
                bfs(n, computers, i);
            }
        }
        return answer;
    }

    //네트워크 찾기
    //computers[1] 에서 1인 애가 방문하지 않았을 경우를 찾기
    public void bfs(int n, int [][]computers, int start){
        Queue<Integer> queue = new LinkedList<>();
        checks[start] =true;
        queue.add(start);

        while(queue.size() !=0){
            int cur = queue.remove();
            for(int i=0; i<n; i++){
                if(!checks[i] && computers[cur][i] ==1 ){
                    queue.add(i);
                    checks[i] =true;
                }
            }
        }
    }
}
//카펫
class CarpetSolution {
    public int[] solution(int brown, int yellow) {

        int plus =(brown-4)/2;

        int width =0;
        int length=0;

        for(int i=1; i<=plus/2; i++){
            width = plus -i;
            if(i*width == yellow){
                length =i;
                break;
            }
        }

        int [] answer = {width+2,length+2};
        return answer;
    }
}

//체육복
class GymsuitSolution {
    public int solution(int n, int[] lost, int[] reserve) {

        HashMap<Integer,Integer> res = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> los = new HashMap<Integer,Integer>();
        int answer = 0;
        int i;
        answer += n-lost.length;

        for( i=0; i<reserve.length; i++){  res.put(reserve[i],1); }

        for(i=0; i<lost.length; i++){
            if( res.containsKey(lost[i])) {
                answer++;
                res.remove(lost[i]);
                lost[i] =0;
            }
        }


        for(i=0; i<lost.length; i++){
            if( lost[i] ==0) continue;

            if( res.containsKey(lost[i]-1)){
                answer++;
                res.remove(lost[i]-1);
            }else if(res.containsKey(lost[i]+1)){
                answer++;
                res.remove(lost[i]+1);
            }
        }
        return answer;
    }
}
