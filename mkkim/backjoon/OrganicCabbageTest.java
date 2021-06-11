package backjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * 2
 * 10 8 17
 * 0 0
 * 1 0
 * 1 1
 * 4 2
 * 4 3
 * 4 5
 * 2 4
 * 3 4
 * 7 4
 * 8 4
 * 9 4
 * 7 5
 * 8 5
 * 9 5
 * 7 6
 * 8 6
 * 9 6
 * 10 10 1
 * 5 5
 */
public class OrganicCabbageTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int horizontal = sc.nextInt();
            int vertical = sc.nextInt();
            int total = sc.nextInt();
            int[][] cabbages = new int[horizontal][vertical];
            for (int j = 0; j < total; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                cabbages[x][y] = 1;
            }

            System.out.println(cabbageWhiteWormCount(cabbages));
        }
    }

    private static int cabbageWhiteWormCount(int[][] cabbages) {
        int count = 0;
        for (int i = 0; i < cabbages.length; i++) {
            for (int j = 0; j < cabbages[0].length; j++) {
                if (cabbages[i][j] != 1) continue;
                dfs(cabbages, i, j);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] cabbages, int i, int j) {
        if(i < 0 || i >= cabbages.length || j < 0 || j >= cabbages[0].length || cabbages[i][j] == 0) return;
        cabbages[i][j] = 0;
        dfs(cabbages, i+1, j); // 상
        dfs(cabbages, i-1, j); // 하
        dfs(cabbages, i, j-1); // 좌
        dfs(cabbages, i, j+1); // 우
    }
}
