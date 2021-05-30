package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * (2) = F(0) + F(1) = 0 + 1 = 1
 * F(3) = F(1) + F(2) = 1 + 1 = 2
 * F(4) = F(2) + F(3) = 1 + 2 = 3
 * F(5) = F(3) + F(4) = 2 + 3 = 5
 */
public class FibonacciTest {
    @Test
    void solution() {
        assertThat(fibonacci(2)).isEqualTo(1);
        assertThat(fibonacci(3)).isEqualTo(2);
        assertThat(fibonacci(4)).isEqualTo(3);
        assertThat(fibonacci(5)).isEqualTo(5);
    }
    /*
    private int fibonacci(int i) {
        if (i == 0 || i == 1) return i;
        int[] memo = new int[i];
        memo[0] = 0;
        memo[1] = 1;
        for (int j = 2; j < i; j++) {
            memo[j] = memo[j-1] + memo[j-2];
        }
        return memo[i-1] + memo[i-2];
    }*/

    public int fibonacci(int i) {
        if (i == 0 || i == 1) return i;
        int[] memo = new int[i+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int j = 2; j < i; j++) {
            memo[j] = caculate(memo[j-1], memo[j-2]);
        }

        return caculate(memo[i-1], memo[i-2]) % 1234567;
    }

    private int caculate(int a, int b) {
        return a % 1234567 + b % 1234567;
    }

}
