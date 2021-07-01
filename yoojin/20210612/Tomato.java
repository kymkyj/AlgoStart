package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int[][] boxes;
    static Queue<Integer> tomas = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i, j;
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        boxes = new int[y][x];
        boolean flag = true; //토마토가 다 익어있는지 체크

        for (i = 0; i <y; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (j = 0; j < x; j++) {
                boxes[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (boxes[i][j] == 1) tomas.add(i * 10 + j);
                if (boxes[i][j] == 0) flag = false;
            }
        }
        if (flag) System.out.println(0);
        else {
            System.out.print(bfs(y,x));
        }

    }

    public static int bfs(int Y, int X) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int days =1;
        while (tomas.size() != 0) {
            for(int t : tomas){
                System.out.println(t);
            }
            System.out.println();
            int toma = tomas.poll();
            int y = toma / 10;
            int x = toma % 10;

            for (int i = 0; i < 4; i++) {
                int xn = x + dx[i];
                int yn = y + dy[i];
                if (xn >= 0 && xn < X && yn >= 0 && yn < Y) {
                    if (boxes[yn][xn] == 0) {
                        boxes[yn][xn] = boxes[y][x] + 1;
                        tomas.add(yn * 10 + xn);
                    }
                }
            }
        }

        for (int i = 0; i < Y; i++) {
            for ( int j = 0; j < X; j++) {
                if (boxes[i][j] == 0) {
                    return -1;
                } else {
                    if (boxes[i][j] - 1 > days) days = boxes[i][j] - 1;
                }
            }
        }
        return days;
    }
}

