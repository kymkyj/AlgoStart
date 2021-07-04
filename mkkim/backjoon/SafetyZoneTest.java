package backjoon;

import java.util.Scanner;

public class SafetyZoneTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] zones = new int[length][length];
        int maxDepth = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                zones[i][j] = sc.nextInt();
                if (maxDepth < zones[i][j]) maxDepth = zones[i][j];
            }
        }
        System.out.println(maxCountSaftyZone(zones, maxDepth));
    }

    private static int maxCountSaftyZone(int[][] zones, int maxDepth) {
        int maxCount = 0;
        for (int i = 0; i <= maxDepth; i++) {
            maxCount = Math.max(maxCount, countSaftyZone(new boolean[zones.length][zones[0].length], zones, i));
        }
        return maxCount;
    }

    private static int countSaftyZone(boolean[][] visited, int[][] zones, int limit) {
        int count = 0;
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[0].length; j++) {
                if (visited[i][j] || zones[i][j] <= limit) continue;
                dfs(visited, zones, i, j, limit);
                count++;
            }
        }
        return count;
    }

    private static void dfs(boolean[][] visited, int[][] zones, int i, int j, int limit) {
        if (i < 0 || i >= zones.length || j < 0 || j >= zones[0].length || visited[i][j] || zones[i][j] <= limit)
            return;
        visited[i][j] = true;
        dfs(visited, zones, i + 1, j, limit); // 상
        dfs(visited, zones, i - 1, j, limit); // 하
        dfs(visited, zones, i, j - 1, limit); // 좌
        dfs(visited, zones, i, j + 1, limit); // 우
    }
}
