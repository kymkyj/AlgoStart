package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetNumberTest {
    private int target;
    
    @Test
    void solution() {
        int[] numbers = {1,1,1,1,1};
        target = 3;
        assertThat(targetNumber(numbers, 0, 0)).isEqualTo(5);
    }

    private int targetNumber(int[] numbers, int index, int sum) {
        if (numbers.length == index) {
            return (sum == target) ? 1 : 0;
        }

        return targetNumber(numbers, index + 1, sum + numbers[index]) + targetNumber(numbers, index + 1, sum - numbers[index]);
    }
}
