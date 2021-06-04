package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class boj1697 {
   static int n, k;
   static int [] ch; // 들린지 체크하기위해
   Queue<Integer> q = new LinkedList<>();
   public int BFS(int n, int k){
       ch = new int[100001];
       ch[n] = 1;
       q.offer(n);
       int L = 0;
       while(!q.isEmpty()){
           // 여기서부터 레벨탐색을 해야함
           int len = q.size(); // 처음에는 수빈이 위치 하나로 len은 1
           for(int i=0; i<len; i++){
               int x = q.poll(); // 원소를 꺼낸다.
//               if(x == k) return L; // 이 경우는 큐에 집어넣었다가 꺼내서 보는 경우
               for(int j=0; j<3; j++){ // j는 세 방법으로 걸을 때(x-1, x+1) 순간이동(x * 2)
                   // nx는 x의 자식노드
                   int nx = 0;
                   if(j == 0){
                       nx = x - 1;
                   }else if(j == 1){
                       nx = x + 1;
                   }else{
                       nx = x * 2;
                   }
                   if(nx >= 1 && nx <= 100000 && ch[nx] == 0){
                       ch[nx] = 1;
                       q.offer(nx);
                   }
                   if(nx == k) return L+1; // 큐에 집어넣을려는 값이 k인가를 보는게 더 낫다
               }
           }
           L++;
       }
       return 0;
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈위치
        int k = Integer.parseInt(st.nextToken()); // 동생위치
        if(n==k){ // 만약에 수빈이랑 동생의 위치가 같을 경우에
            System.out.println(0);
            return;
        }
        boj1697 T = new boj1697();
        System.out.println(T.BFS(n, k));
    }
}
