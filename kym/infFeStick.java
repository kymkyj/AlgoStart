package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
// ()(((()())(())()))(())   17
public class infFeStick {
    public static int solution(String str){
        int answer = 0; // 막대기 길이 더하는 것
        Stack<Character> stack = new Stack<>();
        /*
            foreach로 하게되면 바로 전 꺼를 확인하기가 어렵다.
            강의에서 index 형식으로 하라고 한다.

        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else{
                if(c-1 == '('){ // 이전께 여는괄호 ( 면
                    stack.pop();
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer += 1;
                }
            }
        }
         */
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') stack.push('(');
            else{
                if(str.charAt(i-1) == '('){
                    stack.pop();
                    answer += stack.size();
                }else{
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
