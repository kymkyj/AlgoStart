package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
public class BuildScheduleTest {

    @Test
    void solution() {
        assertThat(buildSchedule(new int[]{93, 30, 55}, new int[]{1, 30, 5})).containsExactly(2,1);
        assertThat(buildSchedule(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).containsExactly(1, 3, 2);
    }

    private int[] buildSchedule(int[] progresses, int[] speeds) {
        Queue<Integer> q = getEndDates(progresses, speeds);
        List<Integer> result = new ArrayList<>();
        int count = 1;
        int pre = q.poll();
        while (!q.isEmpty()) {
            int current = q.poll();
            if (pre >= current) {
                count++;
                continue;
            }

            pre = current;
            result.add(count);
            count = 1;
        }
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private Queue<Integer> getEndDates(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(caculateEndDate(progresses[i], speeds[i]));
        }
        return q;
    }

    private int caculateEndDate(int progress, int speed) {
        return ((100 - progress) % speed == 0) ? (100 - progress) / speed : ((100 - progress) / speed) + 1;
    }

}
