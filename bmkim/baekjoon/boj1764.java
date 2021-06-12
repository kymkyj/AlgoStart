package study.baekjoon.class3;

import java.util.*;

public class boj1764 {
    //[백준 class3] 듣보잡
    static int N; //듣도 못한 사람의 수
    static int M; //보도 못한 사람의 수
    static HashSet<String> people = new HashSet<>();
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i=0; i<N; i++) {
            people.add(scanner.next());
        }

        for (int j=0; j<M; j++) {
            String person = scanner.next();
            if(people.contains(person)) {
                answer.add(person);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (String str : answer) {
            System.out.println(str);
        }
    }
}
