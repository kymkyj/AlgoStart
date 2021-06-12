package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringBomb {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        char[] result;

        for(int i = 0 ; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size()>=bomb.length()){
                if(checkBomb(bomb)){
                    for(int j=0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) System.out.print("FRULA");
        else {
            result = new char [stack.size()] ;
            for(int i = result.length-1; i>=0; i--){
              result[i] =stack.pop();
            }

            System.out.print(result);
        }

//        메모리 초과
//        String str = br.readLine();
//        String bomb = br.readLine();
//        while(str.contains(bomb)) {
//            str = str.replaceAll(bomb, "");
//        }
//
//        if(str.length() == 0) System.out.print("FRULA");
//        else System.out.print(str);
    }

    static public boolean checkBomb(String bomb){
        for(int i =0; i<bomb.length(); i++){
            if(stack.get(stack.size()-bomb.length()+i) == bomb.charAt(i))continue;
            else return false;
        }
        return true;
    }
}

