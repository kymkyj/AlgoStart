package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
일반 큐 사용이 안되는 이유.
-> 우선순위 큐를 구현하는 힙(Heap)은 완전 이진 트리.
   모든 노드에 저장된 값들은 자식 노드들 보다 크거나 같다.(오름차순정렬)

-> 자동 정렬을 통해 가장 빨리 끝나는 시간을 element() 해줌.
 */
public class CountLectures {
    static class Lesson {
        int start;
        int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        int i;
        for(i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lessons.add(new Lesson(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        lessons.sort(new Comparator<Lesson>() {
            @Override
            public int compare(Lesson o1, Lesson o2) {
                if(o1.start == o2.start) return Integer.compare(o1.end,o2.end);
                else return Integer.compare(o1.start,o2.start);
            }
        });

        queue.add(lessons.get(0).end);

        for(i=1; i<n; i++){
            if(queue.element() <= lessons.get(i).start) queue.remove();

            queue.add(lessons.get(i).end);
        }

        System.out.print(queue.size());


    }
}


