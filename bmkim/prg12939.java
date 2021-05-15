package study.programmers.level2;

import java.util.Arrays;
import java.util.stream.Stream;

public class prg12939 {
    public static void main(String[] args) {
        //최솟값과 최댓값
        //str 에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)" 형태의 문자열을 반환하는 함수, solution 을 완성
        Solution solution = new Solution();
        String s = "-1 -2 -3 -4"; //공백으로 구분된 숫자
        System.out.println(solution.solution(s));
    }

    static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] strArray = s.split(" ");

            //1. Arrays.sort()를 이용한 풀이
            /*
            int[] intArray = new int[strArray.length];
            for (int i=0; i<strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            Arrays.sort(intArray);
            answer += intArray[0] + " " + intArray[intArray.length-1];
            */

            //2. Stream을 이용한 풀이
            /*
            int iMax = Arrays.stream(intArray).max().getAsInt();
            int iMin = Arrays.stream(intArray).min().getAsInt();
            */

            //3. 일반적인 최소/최대값 비교를 이용한 풀이
            int num, min, max;
            min = max = Integer.parseInt(strArray[0]);
            for(int i=0; i<strArray.length; i++) {
                num = Integer.parseInt(strArray[i]);
                if (min > num) {
                    min = num;
                }
                if (max < num) {
                    max = num;
                }
            }
            answer += min + " " + max;

            return answer;
        }
    }
}
