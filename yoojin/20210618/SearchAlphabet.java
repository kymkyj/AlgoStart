package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String str = br.readLine();

        for(String a : alphabet){
            System.out.print(str.indexOf(a)+" ");
        }
    }

}

