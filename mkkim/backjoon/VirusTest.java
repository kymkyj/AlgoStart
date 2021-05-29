package backjoon;

import java.util.*;

/**
 * 7
 * 6
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 */
public class VirusTest {
    private static int[][] metrixes;
    private static int count;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int nodeNum = sc.nextInt();
        final int edgeNum = sc.nextInt();
        metrixes = new int[nodeNum+1][nodeNum+1];
        visited = new boolean[nodeNum+1];
        for(int i = 0; i < edgeNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            metrixes[x][y] = metrixes[y][x] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < metrixes[i].length; j++) {
            if (metrixes[i][j] == 1 && visited[j] == false) {
                count++;
                dfs(j);
            }
        }
    }
}
