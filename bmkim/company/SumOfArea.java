package study.company;

import java.util.ArrayList;
import java.util.List;

public class SumOfArea {
    static int[] x, y; //기지국(원의 중심)의 x좌표와 y좌표를 담은 정수 배열
    static int[] radius; //각 기지국이 커버하는 영역의 반지름을 담은 정수 배열
    static int[] v; //정수로 이루어진 난수 배열
    List<Point> points = new ArrayList<>();
    static int result;
    public static void main(String[] args) {
        //몬테카를로 방식으로 면적 계산하는 방법
        //(l + x % (r - l), b + y % (t - b))

        x = new int[]{5};
        y = new int[]{5};
        radius = new int[]{5};
        v = new int[]{92, 83, 14, 45, 66, 37, 28, 9, 10, 81};

        int l = x[0] - x[0];
        int r = x[0] + x[0];
        int b = y[0] - y[0];
        int t = y[0] + y[0];

        //좌표를 순서대로 어떻게 구하지?
        //좌표를 구하고 저장할 곳이 필요하다
        for (int i=0; i<v.length; i++) {
            int x = v[i];
            int x1 = l + x % (r - l);
            int y = v[i];
            int y1 = b + y % (t - b);
        }

        //k는 기지국 영역 내부에 존재하는 점의 비율/생성한 점
        int k = 0;
        //기지국 영역의 면적: k * (r - l) * ( t - b)
        result = k * (r - l) * (t - b);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
