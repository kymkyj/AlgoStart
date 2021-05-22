package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 프로그래머스 신규 아이디 추천
public class proNewId {
    public String solution(String new_id) {
        String answer = "";

        String str1 = upperString(new_id);
        String str2 = replaceString(str1);
        String str3 = replaceComma(str2);
        String str4 = replaceStartEnd(str3);
        String str5 = zeroString(str4);
        String str6 = lengthString(str5);
        String str7 = lengthString2(str6);
        answer = str7;

        return answer;
    }

    public String upperString(String s){
        return s.toLowerCase();
    }
    public String replaceString(String s){
        return s.replaceAll("[^-_.a-z0-9]",""); // [] 안에 ^가 선행하여 등장하면 not
    }
    public String replaceComma(String s){
        return s.replaceAll("[.]{2,}", ".");
    }
    public String replaceStartEnd(String s){
        return s.replaceAll("^[.][.]$", "");
    }
    public String zeroString(String s){
        if(s.equals("")){
            s += "a";
        }
        return s;
//        return s.equals("") ? s += "a" : s;
    }
    public String lengthString(String s){
        return s.length() >= 16 ? s.substring(0, 15).replaceAll("[.]$", "") : s;
    }
    public String lengthString2(String s){
        if(s.length() <= 2){
            while(s.length() < 3){
                s += s.charAt(s.length()-1);
            }
        }
        return s;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        proNewId T = new proNewId();
        System.out.println(T.solution(s));
    }
}
