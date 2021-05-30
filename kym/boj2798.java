package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭
public class boj2798 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input = br.readLine();
       StringTokenizer st = null;
       st = new StringTokenizer(input);

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       String input2 = br.readLine();
       st = new StringTokenizer(input2);

       int [] result = new int[N];
       for(int i=0; i<N; i++){
           result[i] = Integer.parseInt(st.nextToken());
       }
       int resultInt = 0;

       for(int x=0; x<result.length; x++){
           for(int y=x+1; y<result.length; y++){
               for(int z=y+1; z<result.length; z++){
                   int max = result[x]+result[y]+result[z];
                   if(max == M){
                       resultInt = max;
                       break;
                   }
                   if(resultInt < max && max < M) {
                       resultInt = max;
                   }
               }
           }
       }
       System.out.println(resultInt);
    }
}
