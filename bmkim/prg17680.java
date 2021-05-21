package study.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class prg17680 {
    public static void main(String[] args) {
        //1차 캐시
        //캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
        //메모리 상에서 가장 최근에 사용된 적이 없는 캐시의 메모리부터 대체하며 새로운 데이터로 갱신 시켜준다
        //cache hit 일 경우 실행시간은 1 (= CPU 가 참조하고자 하는 메모리가 캐시에 존재할 경우)
        //cache miss 일 경우 실행시간은 5 (= CPU 가 참조하고자 하는 메모리가 캐시에 존재하지 않을 경우)
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        Solution solution = new Solution();
        System.out.println(solution.solution(cacheSize, cities));
    }

    static class Solution {
        //CACHE_HIT 과 CACHE_MISS 는 고정된 실행시간이므로 final 변수로 선언
        static final int CACHE_HIT = 1;
        static final int CACHE_MISS = 5;
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            if (cacheSize == 0) {
                return cities.length*5;
            }
            Queue<String> cache = new LinkedList<>();
            for (int i=0; i< cities.length; i++) {
                String city = cities[i].toUpperCase();

                if(cache.contains(city)) {
                    //메모리에 존재 할 경우, LRU 알고리즘에 의해 우선순위를 맨 뒤로 두기 위해서 큐에서 삭제하고 다시 삽입한다
                    cache.remove(city);
                    cache.offer(city);
                    answer += CACHE_HIT;
                } else {
                    //메모리에 존재하지 않을 경우 캐시에 삽입, 단 주어진 캐시의 사이즈와 현재 사이즈를 비교하여 full 일 경우 맨 처음 값 삭제
                    int currentSize = cache.size();
                    if (currentSize == cacheSize) {
                        cache.poll();
                    }
                    cache.offer(city);
                    answer += CACHE_MISS;
                }
            }
            return answer;
        }
    }
}
