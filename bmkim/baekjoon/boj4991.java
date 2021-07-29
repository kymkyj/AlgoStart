package study.baekjoon.graphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4991 {
    static int w, h; //방의 가로,세로 크기
    static char[][] graph;
    static Position[] list;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) {
        //[백준] 로봇청소기
        //Flood Fill 알고리즘? 모르겠다 ㅠ ㅠ
        Scanner scanner = new Scanner(System.in);

        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            //1. '입력은 여러 개의 테스트케이스로 이루어져 있다' -> 명확한 개수를 왜 명시하지 않는거지? 0 0이라는 입력값을 받으면 끝나는건가?로 이해하였다
            if (w == 0 && h == 0) break;

            // .: 깨끗한 칸
            // *: 더러운 칸
            // x: 가구
            // o: 로봇 청소기의 시작 위치

            graph = new char[w][h];
            list = new Position[11]; //먼지의 최대 개수는 10개
            int dustCount = 1;
            for (int i=0; i<w; i++) {
                for (int j=0; j<h; j++) {
                    graph[i][j] = scanner.next().charAt(0);
                    if (graph[i][j] == 'o') { //0번은 로봇청소기에 대입
                        list[0] = new Position(i, j);
                    } else if (graph[i][j] == '*') {
                        list[dustCount++] = new Position(i, j);
                    }
                }
            }
            process(graph, w, h, dustCount);
            System.out.println(answer);
            //2. '로봇은 같은칸을 여러번 방문할 수 있다' 는 조건이 너무 어렵다. 방문을 체크 할 필요가 없는건가? 어떻게 접근을 해야하는거지
        }

    }

    public static void process(char[][] graph, int w, int h, int dustCount) {
        answer = 0;
        distance = new int[dustCount+1][dustCount+1]; //모든 거리를 저장하는 2차원 배열
        for (int i=0; i<dustCount; i++) {
            for (int j=i+1; j<dustCount; j++) {

            }
        }
    }

    public static int BFS(char[][] graph, int w, int h, Position a, Position b) {
        visited = new boolean[w][h];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(a);
        visited[a.x][a.y] = true;
        graph[a.x][a.y] = '.';

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Position current = queue.poll();
                int x = current.x;
                int y = current.y;

                if (x == b.x && y == b.y) {
                    return count;
                }

                for (int j=0; j<4; j++) {
                    int wx = x + dx[j];
                    int hy = y + dy[i];
                    //아 도저히 못풀겠다 이해를 못하겠군
                }
            }
        }
        return -1;
    }

    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
