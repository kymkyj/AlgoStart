import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프로그래머스 스킬트리
// "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
// "CBD"	["BACDE", "CBADF", "AECB", "BDA", "CDA"]
public class proSkillTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        String [] s2 = new String[N];
        for(int i=0; i<N; i++){
            s2[i] = st.nextToken();
        }
        System.out.println(solution(s1, s2));
//        s.solution(s1, s2);
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0; // count 수
        Queue<Character> skillQueue = new LinkedList<>();
        ArrayList<Boolean> arr = new ArrayList<>();
        for(int i=0; i<skill_trees.length; i++){ // skill_trees 크기만큼
            StringBuilder sb = new StringBuilder();
            char [] c1 = skill_trees[i].toCharArray();
            for(int j=0; j<c1.length; j++){
                skillQueue.offer(c1[j]);
            }
            while(skillQueue.size() != 0){
                String temp = skillQueue.poll().toString();
                if(skill.contains(temp)){
                    sb.append(temp);
                }
            }
            boolean tmp = true; // 스위칭 변수 필요
            String result = sb.toString();
            for(int j=0; j<result.length(); j++){
                if(skill.charAt(j)-'A' != result.charAt(j)-'A'){
                    tmp = false;
                    break;
                }
            }
            arr.add(tmp);
            sb.setLength(0); // Builder 초기화
        }
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i) == true){
                answer++;
            }
        }
        return answer;
    }
}


