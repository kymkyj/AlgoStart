package study.baekjoon.graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj5014 {
    static int F, S, G, U, D;
    static boolean[] visited;
    public static void main(String[] args) {
        //[백준] 스타트링크
        Scanner scanner = new Scanner(System.in);
        F = scanner.nextInt(); //최고층
        S = scanner.nextInt(); //내가 속한 층
        G = scanner.nextInt(); //내가 가야할 층
        U = scanner.nextInt(); //위로 U층
        D = scanner.nextInt(); //아래로 D층
        visited = new boolean[F+1];

        int answer = BFS();
        if (answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }

   public static int BFS() {
       Queue<Stair> queue = new LinkedList<>();
       queue.add(new Stair(S, 0));
       visited[S] = true;

       while(!queue.isEmpty()) {
           Stair current = queue.poll();

           if (current.pos == G) return current.count;
           if (current.pos + U <= F && !visited[current.pos + U]) {
               queue.offer(new Stair(current.pos + U, current.count+1));
               visited[current.pos + U] = true;
           }
           if (current.pos - D > 0 && !visited[current.pos - D]) {
               queue.offer(new Stair(current.pos - D, current.count+1));
               visited[current.pos - D] = true;
           }
       }
       return -1;
   }

   public static class Stair {
        int pos;
        int count;

        public Stair(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
   }
}
