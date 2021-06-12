package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 주식투자
/*
    2
    4
    500 800 200
    300 0 300
    -100 -200 -400
    600 200 300
    3
    451 234 309
    224 334 467
    143 246 245
 */
public class boj13416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int jusic [][] = new int[N][3];
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<3; k++){
                    jusic[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int index = 0;
            int sum = 0;
            while(index < N) {
                int max = 0;
                for (int j = 0; j < 3; j++) {
                    if(jusic[index][j] < 0){
                        continue;
                    }
                    if(jusic[index][j] > max){
                        max = jusic[index][j];
                    }
                }
                sum += max;
                index++;
            }
            list.add(sum);
        }
        for(int j=0; j<list.size(); j++){
            System.out.println(list.get(j));
        }
    }
}
