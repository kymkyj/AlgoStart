package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 잃어버린 괄호
public class boj1541 {
    public static int solution(ArrayList<Integer> list){
        int answer = list.get(0);
        if(answer < 0){
            answer = answer * -1;
        }
        for(int i=1; i<list.size(); i++){
            answer -= list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>(); // 몇개의 수가 올지 모르기 떄문??
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-"); // 55 50+40 여기까지 이상태
        while(st.hasMoreTokens()){
            int tmp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }
            list.add(tmp);
        }
        System.out.println(solution(list));
    }
}
