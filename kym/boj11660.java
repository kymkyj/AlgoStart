package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 구간 합 구하기 5
/*
    4 3         ->  27 6 64
    1 2 3 4
    2 3 4 5
    3 4 5 6
    4 5 6 7
    2 2 3 4
    3 4 3 4
    1 1 4 4
 */
// N범위만큼 계산해서 2차원배열 만들어서 board 만들기
// 어레이 리스트 안에 Gugan 클래스로 x값 y값 담아서 넣기
// 이중 for문돌면서 어레이 리스트에서 꺼내와서 첫번째 x에서 두번째 x값 까지
// 다음 for문에서 첫번째 y에서 두번째 y까지 돌면서 board에서 값 찾아서 더하기
class Gugan {
    public int x, y;
    Gugan(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj11660 {
    static int n, m;
    static int [][] board;
    static ArrayList<Gugan> list = new ArrayList<>();
    public static int solution(){
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int [n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                int tmpX = Integer.parseInt(st.nextToken());
                int tmpY = Integer.parseInt(st.nextToken());
                System.out.println(tmpX + ' ' + tmpY);
                list.add(new Gugan(tmpX, tmpY));
            }
        }
    }
}
