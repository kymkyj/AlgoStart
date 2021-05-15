package programmers;
// 프로그래머스 최댓값과 최솟값
public class proMaxAndMin {
    public static String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String [] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            if(Integer.parseInt(arr[i]) > max){
                max = Integer.parseInt(arr[i]);
            }
            if(Integer.parseInt(arr[i]) < min){
                min = Integer.parseInt(arr[i]);
            }
        }
        answer = min + " " + max;
        return answer;
    }
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
}
