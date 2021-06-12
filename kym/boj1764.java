package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 듣보잡
/*
    3 4                 2
    ohhenrie            baesangwook
    charlie             ohhenrie
    baesangwook
    obama
    baesangwook
    ohhenrie
    clinton
 */
public class boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> s = new HashSet<>();
        List<String> answer = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 놈
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 놈
        for(int i=0; i<N; i++){
            s.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            if(s.contains(tmp)) answer.add(tmp); continue;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(String k : answer){
            System.out.println(k);
        }
    }
}
