package study.company;

import java.util.*;

public class TransferSystem {
    static List<Integer>[] routes, edges;
    static boolean[] visitedRoute, visitedStation;
    //static String[] subway = new String[]{"1 2 3 4 5 6 7 8 9 10", "2 8"}; //지하철 노선도
    static String[] subway = new String[]{"0 1 2 3 4", "1 12 13 14"}; //지하철 노선도
    //static int start = 1; //시작역
    static int start = 2; //시작역
    //static int end = 10; //도착역
    static int end = 12; //도착역
    public static void main(String[] args) {
        //올리브영 코딩테스트 2번
        //1호선: 1 2 3 4 5 6 7 8
        //2호선: 2 11
        //3호선: 0 11 10
        //4호선: 3 17 19 12 13 9 14 15 10
        //5호선: 20 2 21

        //역에 대해서 크기를 얼마나 줘야할까?
        routes = new ArrayList[subway.length + 1]; //호선
        edges = new ArrayList[end + 1];//역

        for (int i=0; i<=subway.length; i++) routes[i] = new ArrayList<>();
        for (int i=0; i<=end; i++) edges[i] = new ArrayList<>();
        for (int i=0; i<subway.length; i++) {
            String[] str = subway[i].split(" ");
            for (int j=0; j<str.length-1; j++) {
                int station = Integer.parseInt(str[j]);
                routes[i].add(station);
                edges[station].add(i);
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        visitedRoute = new boolean[subway.length + 1]; //호선 방문 체크
        visitedStation = new boolean[end + 1]; //역 방문 체크

        Queue<Node> queue = new LinkedList<>();
        visitedStation[start] = true;
        for (int v : edges[start]) {
            visitedRoute[v] = true;
            queue.offer(new Node(v, 0));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int v : routes[node.to]) {
                if (v == end) return node.count;
                if (visitedStation[v]) continue;
                visitedStation[v] = true;
                for (int nv : edges[v]) {
                    if (visitedRoute[nv]) continue;
                    visitedRoute[nv] = true;
                    queue.offer(new Node(nv, node.count + 1));
                }
            }
        }
        return -1;
    }
    
    static class Node {
        int to, count;
        public Node(int to, int count) {
            this.to = to;
            this.count = count;
        }
    }
}
