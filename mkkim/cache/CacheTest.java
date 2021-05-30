package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
 * 3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
 * 2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
 * 5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
 * 2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
 * 0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
 */
public class CacheTest {
    @Test
    void solution() {
        String[] words = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(cacheTime(0, words)).isEqualTo(25);
    }
    // 75점 -> 오래 사용되지 않다가 최근 사용되면 우선순위가 올라감.. 이걸 생각 못했
    private int cacheTime(int cacheSize, String[] cities) {
        Map<String, Cache> map = new LinkedHashMap<>();
        if (cacheSize == 0 ) {
            return cities.length * 5;
        }
        int cacheTime = 0;
        for (String city : cities) {
            if (map.containsKey(city.toLowerCase())) {
                map.get(city.toLowerCase()).count();
                cacheTime += 1;
            } else {
                cacheTime += 5;
                if (!map.isEmpty() && cacheSize <= map.size()) {
                    PriorityQueue<Cache> pq = new PriorityQueue<>();
                    for (Cache cache : map.values()) {
                        pq.offer(cache);
                    }
                    map.remove(pq.poll().city());
                }
                map.put(city.toLowerCase(), new Cache(city.toLowerCase()));
            }
        }

        return cacheTime;
    }

    // Success 앞과 뒤 삽입 삭제가 가능한 Dequeue 자료 구조를 활용
    private int cacheTime2(int cacheSize, String[] cities) {
        if (cacheSize == 0 || cities.length == 0) {
            return cities.length * 5;
        }
        int cacheTime = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (String city : cities) {
            if (cache.remove(city.toLowerCase())) {
                cacheTime++;
                cache.addFirst(city.toLowerCase());
                continue;
            }

            cacheTime += 5;
            if (cache.size() == cacheSize) {
                cache.removeLast();
            }

            cache.addFirst(city.toLowerCase());

        }

        return cacheTime;
    }


}

class Cache implements Comparable<Cache> {
    private String city;
    private int count;

    public Cache(String city) {
        this.city = city;
        this.count = 1;
    }

    public void increaseCount() {
        this.count++;
    }

    public int count() {
        return count;
    }

    public String city() {
        return city;
    }

    @Override
    public int compareTo(Cache o) {
        return (this.count < o.count) ? -1 : 1;
    }
}
