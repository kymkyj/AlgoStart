package study.programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class prg42839 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String numbers = "011";
        System.out.println(solution.solution(numbers));
    }

    static class Solution {
        private TreeSet<String> set = new TreeSet<>();
        private int count = 0;

        public int solution(String numbers) {
            int size = numbers.length();
            List<Character> characterList = new ArrayList<>();
            List<Character> result = new ArrayList<>();

            for (int i=0; i<size; i++) {
                characterList.add(numbers.charAt(i));
            }

            for (int i=0; i<size; i++) {
                permutation(characterList, result, size, i+1);
            }

            return count;
        }

        //순열
        public void permutation(List<Character> arr, List<Character> result, int n, int r) {

            if (r == 0) {
                // 0으로 시작하는 부분집합은 제외
                if (result.get(0) != '0') {

                    String str = "";
                    int size = result.size();
                    for (int i = 0; i < size; i++) {
                        str += result.get(i);
                    }

                    int num = 0;

                    // 이미 나온 숫자 조합이 아닐 경우
                    if (!set.contains(str)) {
                        num = Integer.parseInt(str);
                        set.add(str);

                        // 소수 판별
                        if (isPrime(num)) {
                            //System.out.println(num);
                            count++;
                        }
                    }
                }
                return;
            }

            for (int i = 0; i < n; i++) {
                result.add(arr.remove(i));
                permutation(arr, result, n - 1, r - 1);
                arr.add(i, result.remove(result.size() - 1));
            }

        }

        //소수 판별
        public boolean isPrime(int number) {
            if (number == 2) return true;
            if (number == 1 || number % 2 == 0) return false;
            for (int i=3; i<=Math.sqrt(number); i += 2) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }
}
