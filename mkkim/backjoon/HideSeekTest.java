package backjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideSeekTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(bfs(start, end));
    }

    private static int bfs(int start, int end) {
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<>();
        int[] counts = new int[100001];
        boolean[] check = new boolean[100001];
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) break;
            status[0] = current - 1;
            status[1] = current + 1;
            status[2] = current * 2;
            for (int i = 0; i < status.length; i++) {
                if (status[i] >= 0 && status[i] <= 100000 && counts[status[i]] == 0 && !check[status[i]]) {
                    q.add(status[i]);
                    check[status[i]] = true;
                    counts[status[i]] = counts[current] + 1;
                }
            }
        }
        return counts[end];
    }

}
