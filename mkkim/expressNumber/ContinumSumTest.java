package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContinumSumTest {
    @Test
    void solution() {
        assertThat(continueSum(15)).isEqualTo(4);
    }

    private int continueSum(int n) {
        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            int sum = 0;
            for (int k = i; k <= n; k++) {
                sum += k;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
