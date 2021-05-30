package programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * "1 2 3 4"	"1 4"
 * "-1 -2 -3 -4"	"-4 -1"
 * "-1 -1"	"-1 -1"
 */
public class MaxMinTest {
    @Test
    void solution() {
        assertThat(maxMin("1 2 3 4")).isEqualTo("1 4");
        assertThat(maxMin("-1 -2 -3 -4")).isEqualTo("-4 -1");
        assertThat(maxMin("-1 -1")).isEqualTo("-1 -1");
    }

    private String maxMin(String s) {
        int[] sorted = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        StringBuffer answer = new StringBuffer();
        answer.append(sorted[0]);
        answer.append(" ");
        answer.append(sorted[sorted.length-1]);
        return answer.toString();
    }
}
