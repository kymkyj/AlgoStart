package bojNaming;

import java.io.*;
import java.util.StringTokenizer;

public class bojFoodAvoid {
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int cnt;
    // 상좌하우
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void dfs(int curR, int curC){
        visited[curR][curC] = true;
        cnt ++; // 방문할 때마다 개수 추가
        // 거리 확인
        for (int i = 0; i < 4; i++) {
            int nextR = curR + dx[i];
            int nextC = curC + dy[i];

            if(nextR < 1 || nextC < 1 || nextR >= n+1 || nextC >= m+1) continue;
            else if (board[nextR][nextC] == 1 && !visited[nextR][nextC])
                dfs(nextR, nextC);
        }

    }

    /* 먼저 입력 값 받자 */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // map 설정하고 방문여부 확인 이차원배열
        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i < k+1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[r][c] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int temp = cnt;
                    cnt = 0;
                    dfs(i, j);
                    cnt = Math.max(cnt, temp);
                }
            }
        }

        System.out.print(cnt + "");
    }
}
