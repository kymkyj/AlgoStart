package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BaeminOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solution("Jone Doe, Peter Benjamin Parker, Mary Jane Waston-Parker, John Eivis Doe, John Evan Doe, Jane Doe, Peter Brian Parker","Example");
    }

    static public void solution(String s, String c){
        String [] names = s.split(", ");
        ArrayList<String> emails = new ArrayList<>();

        for( int i=0; i< names.length; i++){
            String [] name = names[i].split(" ");

            for(int j=0; j< name.length; j++){
             name[j] =  name[j].toLowerCase().replace("-","");
            }
            String email = name[0]+"."+name[name.length-1]+"@"+c+".com";

            if(emails.contains(email)){
                int cnt =0;
                for( String e: emails){
                    if(e.contains(name[0]+"."+name[name.length-1])) cnt++;
                }
                email = name[0]+"."+name[name.length-1]+(cnt+1)+"@"+c.toLowerCase()+".com";
            }
            emails.add(email);
        }
        String result ="";
        for(int i=0; i<names.length; i++){
            if(i == names.length-1) result +=names[i]+" <"+emails.get(i)+">";
            else result +=names[i]+" <"+emails.get(i)+">, ";
        }

        System.out.print(result);



    }
}