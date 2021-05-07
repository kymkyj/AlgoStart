package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 프린터 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 * <p>
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * <p>
 * [2, 1, 3, 2]	2	1
 * [1, 1, 9, 1, 1, 1]	0	5
 */
public class PrinterTest {

    @Test
    void solution() {
        int[] nums = {1, 1, 9, 1, 1, 1};
        int location = 0;
        assertThat(printer2(nums, location)).isEqualTo(5);
    }


    private int printer(int[] nums, int location) {
        Queue<Printer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            q.offer(new Printer(nums[i], i));
            pq.offer(nums[i]);
        }
        int orderNumber = 1;
        while (!q.isEmpty()) {
            if (q.peek().getPriority() == pq.peek()) {
                if (q.peek().getLocation() == location) {
                    return orderNumber;
                }
                orderNumber++;
                q.poll();
                pq.poll();
            } else {
                q.offer(q.poll());
            }
        }
        return orderNumber;

    }

    // 모범 답
    int printer2(int[] priorities, int location) {
        int answer = 0;


        Queue<Integer> que = new LinkedList<Integer>();
        for (int i : priorities) {
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            Integer i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                location--;
                if (location < 0)
                    break;
            } else {
                que.add(i);
                location--;
                if (location < 0)
                    location = que.size() - 1;
            }
        }

        return answer;
    }

    public int printer3(int[] priorities, int location) {
        // 내림차순
        List<Integer> prioritiesOrderByDesc = Arrays.stream(priorities)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        Queue<Printer> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Printer(priorities[i], i));
        }
        int answer = 1;
        int index = 0;
        while (!q.isEmpty()) {
            if (q.peek().getPriority() == prioritiesOrderByDesc.get(index)) {
                if (q.peek().getLocation() == location) {
                    return answer;
                }
                index++;
                answer++;
                q.poll();
            } else {
                q.offer(q.poll());
            }
        }
        return answer;
    }

}

class Printer {
    private int priority;
    private int location;

    public Printer(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

    public int getPriority() {
        return priority;
    }

    public int getLocation() {
        return location;
    }
}
