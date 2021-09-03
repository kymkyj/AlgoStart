package study.programmers.level3;

import java.util.*;

public class prg42627 {
    public static void main(String[] args) {
        //[프로그래머스] 디스크 컨트롤러
        //SJF 알고리즘 구현
        Solution solution = new Solution();
        //jobs = [작업이 요청되는 시점, 작업의 소요시간]
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        System.out.println(solution.solution(jobs));
    }

    static class Solution {
        public int solution(int[][] jobs) {
            LinkedList<Job> waiting = new LinkedList<>(); //대기 큐
            PriorityQueue<Job> priorityQueue = new PriorityQueue<>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.workingTime - o2.workingTime;
                }
            });

            for (int[] job : jobs) {
                waiting.offer(new Job(job[0], job[1]));
            }

            Collections.sort(waiting, new Comparator<Job>() {
                //요청시간을 기준으로 오름차순 정렬
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.requestTime - o2.requestTime;
                }
            });

            int answer = 0;
            int count = 0;
            int time = waiting.peek().requestTime;

            while (count < jobs.length) {
                while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                    //현재 시간 이하의 요청시간을 가지는 작업을 모두 대기큐에서 작업큐로 옮긴다
                    priorityQueue.offer(waiting.pollFirst());
                }

                if(!priorityQueue.isEmpty()) {
                    Job job = priorityQueue.poll();
                    //현재 시간에 현재 작업의 작업시간을 더해준다
                    time += job.workingTime;
                    //각 작업의 Turn Arround Time을 answer에 더한다
                    answer += time - job.requestTime;
                    //완료 시 +1
                    count++;
                } else {
                    //비어있는 경우 현재 시간 +1
                    time++;
                }
            }
            return answer / count;
        }

        class Job {
            int requestTime;
            int workingTime;

            Job(int requestTime, int workingTime) {
                this.requestTime = requestTime;
                this.workingTime = workingTime;
            }
        }
    }
}
