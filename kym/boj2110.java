package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
/*
    5 3
    1
    2
    8
    4
    9
 */
public class boj2110 {
    static int lt, rt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집의 수
        int c = Integer.parseInt(st.nextToken()); // 공유기 수
        int [] arr = new int[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        lt = 1; //최소 길이
        rt = arr[n - 1] - arr[0];// 최대 길이
        while (lt <= rt) { // 3 < 4
            int mid = (lt + rt) / 2; // 공유기를 몇단계마다 설치할 지 확인하는 중간 값
            int firstModem = arr[0]; // 첫 위치에는 무조건 설치해야함
            int count = 1; //공유기 설치 개수
            for (int i = 0; i < n; i++) {
                int dis = arr[i] - firstModem;
                if (dis >= mid) { //거리차가 기준보다 이상되야 설치 가능
                    count++;
                    firstModem = arr[i];
                }
            }
            if (count >= c) { //공유기 설치가 더 많이 됬으니 간격을 넓혀서 줄여야함
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
