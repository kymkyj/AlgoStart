package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class baekjoon_4949_20210904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<String>();
        Stack<Character> stack =new Stack<>();
        StringBuffer result =new StringBuffer();

        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;
            strs.add(s);
        }

        for(String str : strs){
            String r="yes";
            for(char c: str.toCharArray()){
                if(c=='(' || c=='[') stack.push(c);
                else if(c==')'){
                    if(stack.isEmpty() || stack.peek() !='('){
                        stack.push(c);
                        break;
                    }
                    if(stack.peek()=='(')stack.pop();
                }else if(c==']'){
                    if(stack.isEmpty() || stack.peek() !='[') {
                        stack.push(c);
                        break;
                    }
                    if(stack.peek()=='[') stack.pop();
                }else continue;
            }

            if(stack.isEmpty()) result.append("yes\n");
            else result.append("no\n");
            stack.clear();
        }

        System.out.print(result);

    }
}