package study.baekjoon.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {
    static int N, K;
    static int[] visited;
    public static void main(String[] args) {
        //숨바꼭질
        //이 문제는 전혀 BFS로 접근할 생각을 하지 못했다;
        Scanner scanner = new Scanner(System.in);
        //5 17
        N = scanner.nextInt(); //수빈의 점
        K = scanner.nextInt(); //동생의 점
        //0보다 크거나 같고 100000보다 작거나 같으니 100001로 초기화
        visited = new int[100001];

        //예외처리
        if (N == K) {
            System.out.println(0);
        } else {
            BFS(N);
        }
    }

    static void BFS(int number) {
        Queue<Integer> queue = new LinkedList<>();
        //방문 및 큐에 초기값 세팅
        visited[number] = 1;
        queue.add(number);

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            //+1, -1, *2 순서대로 큐에 삽입한다
            for (int i=0; i<3; i++) {
                int next = 0;
                if(i == 0) {
                    next = temp+1;
                } else if (i == 1) {
                    next = temp-1;
                } else if (i == 2) {
                    next = temp*2;
                }

                //큐의 값과 목표지점(동생의 위치)가 동일한 순간 방문한 count 출력
                if (next == K) {
                    System.out.println(visited[temp]);
                    return;
                }

                //방문 안했을 경우 큐에 삽입 후 상태를 전 위치값+1 해준다
                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    //개인적으로 상태를 전 위치값+1 하는 부분이 어렵다
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}
