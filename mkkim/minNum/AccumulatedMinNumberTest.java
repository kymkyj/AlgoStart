package programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [1, 4, 2]	[5, 4, 4]	29
 * [1,2]	[3,4]	10
 */
public class AccumulatedMinNumberTest {
    @Test
    void solution() {
        int[] a = {1,2};
        int[] b = {3,4};
        assertThat(accumulatedMinNumber3(a,b)).isEqualTo(10);
    }

    private int accumulatedMinNumber(int[] first, int[] second) {
        Arrays.sort(first);
        PriorityQueue<Integer> pq = new PriorityQueue<>(second.length,
                (a,b) -> b - a);

        for (int num : second) {
            pq.offer(num);
        }
        int[] memo = new int[first.length];
        memo[0] = first[0] * pq.poll();
        for (int i = 1; i < first.length; i++) {
            memo[i] = (first[i] * pq.poll()) + memo[i-1];
        }

        return memo[first.length-1];
    }

    private int accumulatedMinNumber2(int[] first, int[] second) {
        int length = first.length;
        PriorityQueue<Integer> firstPq = new PriorityQueue<>(length,
                (a,b) -> a - b);
        PriorityQueue<Integer> secondPq = new PriorityQueue<>(length,
                (a,b) -> b - a);

        for (int i = 0; i < length; i++) {
            firstPq.offer(first[i]);
            secondPq.offer(second[i]);
        }

        int[] memo = new int[length];
        memo[0] = firstPq.poll() * secondPq.poll();
        for (int i = 1; i < length; i++) {
            memo[i] = (firstPq.poll() * secondPq.poll()) + memo[i-1];
        }

        return memo[length-1];
    }
    // 이게 젤 성능 좋음
    private int accumulatedMinNumber3(int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        int[] memo = new int[first.length];
        int size = second.length-1;
        memo[0] = first[0] * second[size];
        for (int i = 1; i < first.length; i++) {
            memo[i] = (first[i] * second[size -i]) + memo[i-1];
        }

        return memo[first.length-1];
    }
}
