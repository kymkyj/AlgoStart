package com.practice;
import java.util.*;

//여행경로
class TravelrouteSolution {
    static int cnt;
    static  HashMap<String, ArrayList<String>> map = new HashMap<>();
    static ArrayList<String>result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        cnt = tickets.length;

        cnt = tickets.length;
        String [] answer = new String [cnt];

        for(int i=0; i<cnt; i++){
            if(map.containsKey(tickets[i][0])){
                ArrayList<String> route = map.get(tickets[i][0]);
                route.add(tickets[i][1]);
                Collections.sort(route);
                map.put(tickets[i][0], route);
            }else{
                ArrayList<String> route = new ArrayList<>();
                route.add(tickets[i][1]);
                map.put(tickets[i][0], route);
            }
        }

        result.add("ICN");
        dfs("ICN");
        answer = result.toArray(new String[result.size()]);

        return answer;
    }

    static public void dfs(String from){
        if(!map.containsKey(from)){
            return;
        }
        if(map.get(from).size() == 0 ){
            return;
        }

        while(map.get(from).size() !=0){
            String to= map.get(from).get(0);
            result.add(to);
            ArrayList<String> route = map.get(from);
            route.remove(to);
            map.put(from,route);
            dfs(to);
        }
    }
}

//큰 수 만들기
class MakebiggernumSolution {
    public String solution(String number, int k) {
        String answer = "";
        int [] nums = new int [number.length()];
        int i, max, start = -1, cnt =number.length()-k;

        for(i=0; i<number.length();i++){nums[i] =number.charAt(i) - '0';}

        while(cnt>0){
            max = nums[++start];
            for(i=start; i<nums.length-cnt+1; i++){
                if(nums[i]>max){
                    max =nums[i];
                    start= i;
                }
                if(max==9) break;
            }
            answer += max;
            cnt--;
        }

        return answer;
    }
}

//디스크 컨트롤러
class DiskcontrollerSolution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int pos =0;
        int time =0;
        // 시작시간 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[]o2){
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[]o2){
                return o1[1]-o2[1];
            }
        });

        while (pos < jobs.length || !pq.isEmpty()) {
            for (; pos < jobs.length && jobs[pos][0] <= time; pos++){
                pq.offer(jobs[pos]);
            }


            if (pq.peek() != null && pq.peek()[0] <= time) {
                time += pq.peek()[1];
                answer += (time - pq.peek()[0]);
                pq.poll();
            } else
                time++;
        }

        return answer / jobs.length;
    }
}