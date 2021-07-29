package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 늑대와 양
public class bojWolfAndSheep {
    static int r, c;
    static char [][] map;
    static int [] dx = {-1, 0, 1, 0}; // 상하좌우
    static int [] dy = {0, 1, 0, -1};
//    static Queue<Character> Q = new LinkedList<>();
    static boolean answer = true;

//    public void BFS(int x, int y){
//        for(int i=0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[y];
//            if(nx >= 0 && nx < r && ny >= 0 && ny < c){
//                if(map[nx][ny] == '.'){
//                    map[nx][ny] = 'D';
//                }else if(map[nx][ny] == 'S'){ // 양을 만나면 늑대가 잡아먹으니..
//                    System.out.println(0);
//                    answer = false;
//                    return;
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        bojWolfAndSheep T = new bojWolfAndSheep();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
//                if(str.charAt(j) == '.'){
//                    map[i][j] = 'D';
//                }else {
//                    map[i][j] = str.charAt(j);
//                }
                map[i][j] = str.charAt(j);
            }
        }

//        for(int i=0; i<r; i++) {
//            for(int j=0; j<c; j++) {
//                if(map[i][j] == 'W'){
//                    T.BFS(r, c);
//                }
//            }
//        }
//        if(!answer){
//            System.out.println(0);
//        }else{
//            StringBuilder sb = new StringBuilder();
//            System.out.println(1);
//            for(int i=0;i<r;i++) {
//                sb.append(map[i]);
//                sb.append("\n");
//            }
//            System.out.println(sb);
//        }

        //늑대 주위에 울타리
        //늑대 옆에 양 바로 있으면 무조건 0 출력
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(map[i][j] == 'W') {
                    for(int k = 0 ; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        //목장 안에 있을때
                        if(nx >=0 && nx< r && ny >=0 && ny<c) {
                            if(map[nx][ny]=='.') {
                                map[nx][ny]='D';
                            }else if(map[nx][ny]=='S') {
                                answer = false;
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
        }

        if(!answer) {
            System.out.println(0);
        }else {
            StringBuilder sb = new StringBuilder();
            System.out.println(1);
            for(int i=0;i<r;i++) {
                sb.append(map[i]);
                sb.append("\n");
            }
            System.out.println(sb);
        }

    }
}
