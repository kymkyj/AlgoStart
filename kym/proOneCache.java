package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 프로그래머스 1차캐시
public class proOneCache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0; // 캐시 수행시간 카운트
        String [] cache = new String[cacheSize];
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(String s : cities){
            int pos = -1;
            for(int i=0; i<cacheSize; i++){
                if(s.equalsIgnoreCase(cache[i])) {
                    pos = i; // hit
                }
            }
            if(pos==-1){ // miss
                for(int j=cache.length-1; j>=1; j--){
                    cache[j] = cache[j-1];
                }
                answer = answer + 5;
            }else{ // hit
                for(int j=pos; j>=1; j--){
                    cache[j] = cache[j-1];
                }
                answer++;
            }
            cache[0] = s;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //String [] citys = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String [] citys = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        proOneCache T = new proOneCache();
        System.out.println(T.solution(n, citys));
    }
}
