package study.baekjoon.greedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11000 {
    public static void main(String[] args) {
        //[백준] 강의실 배정
        //많은 개념이 필요했던 문제라 아주 어렵다 ^_^!
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Lecture[] lectures = new Lecture[N];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            int S = scanner.nextInt();
            int T = scanner.nextInt();
            lectures[i] = new Lecture(S,T);
        }
        Arrays.sort(lectures);
        priorityQueue.offer(lectures[0].end);

        for (int i=1; i<N; i++) {
            //lectures[0]은 대입 했으므로 1부터 시작
            if (lectures[i].start >= priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.offer(lectures[i].end);
        }

        //최종적으로 우선순위 큐에 남아있는 것이 강의를 배정하는 동안 사용한 총 강의실의 수
        System.out.println(priorityQueue.size());
    }
}

class Lecture implements Comparable<Lecture> {
    int start, end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        //Object 비교 시 비교기준을 정해주어야 한다
        //오름차순
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
