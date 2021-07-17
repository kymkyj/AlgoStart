package boj;
// 연속합
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj1912 {
    static int [] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        dy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[0] = arr[0]; // dy[0]은 첫원소로 arr[0]으로 초기화
        int max = arr[0]; // max도 동일하게 배열의 첫번쨰 값으로 초기화

        for (int i = 1; i < N; i++) {
            // 이전 dy 값과 현재 arr값 더한것과 현재 arr값 중 큰값을 저장
            dy[i] = Math.max(dy[i - 1] + arr[i], arr[i]);
            // 최댓값 갱신
            max = Math.max(max, dy[i]);
        }
        System.out.println(max);

    }
}