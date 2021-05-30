package study.programmers.level1;

public class prg72410 {
    public static void main(String[] args) {
        //신규 아이디 추천
        Solution solution = new Solution();
        String new_id = "b......@";
        System.out.println(solution.solution(new_id));
    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";
            //1. 대문자를 소문자로 치환
            String stage1 = new_id.toLowerCase();

            //2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
            StringBuilder stage2 = new StringBuilder();
            char[] chars = stage1.toCharArray();
            for (char ch : chars) {
                if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch == '-' || ch == '_' || ch == '.')) {
                    stage2.append(ch);
                }
            }

            //3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            String stage3 = stage2.toString().replace("..", ".");
            while (stage3.contains("..")) {
                stage3 = stage3.replace("..", ".");
            }

            //4. 마침표(.)가 처음이나 끝에 위치한다면 제거
            String stage4 = stage3;
            if (stage4.length() > 0) {
                if (stage4.charAt(0) == '.') {
                    stage4 = stage4.substring(1, stage4.length());
                }
            }

            if (stage4.length() > 0) {
                if (stage4.charAt(stage4.length()-1) == '.') {
                    stage4 = stage4.substring(0, stage4.length()-1);
                }
            }


            //5. 빈 문자열이라면, new_id에 "a"를 대입
            String stage5 = stage4;
            if (stage5.equals("")) {
                stage5 = "a";
            }

            //6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거, 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
            String stage6 = stage5;
            if (stage6.length() >= 16) {
                stage6 = stage5.substring(0, 15);
                if (stage6.charAt(stage6.length()-1) == '.') {
                    stage6 = stage6.substring(0, stage6.length()-1);
                }
            }

            //7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙이기
            StringBuilder stage7 = new StringBuilder(stage6);
            if (stage7.length() <= 2) {
                char ch = stage7.charAt(stage7.length()-1);
                while (stage7.length() < 3) {
                    stage7.append(ch);
                }
            }
            answer = String.valueOf(stage7);
            //정규표현식을 이용했을 경우
            /*
            String nickname = "";
            nickname = new_id.toLowerCase();
            nickname = nickname.replaceAll("[^-_.a-z0-9]", "");
            nickname = nickname.replaceAll("[.]{2,}", ".");
            nickname = nickname.replaceAll("^[.]|[.]$", "");
            if (nickname.length() == 0) {
                nickname += "a";
            }
            if (nickname.length() >= 16) {
                nickname = nickname.substring(0, 15);
                nickname = nickname.replaceAll("^[.]|[.]$", "");
            }
            if (nickname.length() <= 2) {
                while (nickname.length() < 3) {
                    nickname += nickname.charAt(nickname.length()-1);
                }
            }
            answer = nickname;
            */
            return answer;
        }
    }
}
