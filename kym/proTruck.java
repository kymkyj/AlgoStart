import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 다리를 지나는 트럭
// 2 	10	[7,4,5,6]	8
public class proTruck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(",");
        int [] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(N, W, nums));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length 다리길이
        // weight 다리가 견디는 최대 무게
        // truck_weights 트럭별 무게 배열
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>(); // 다리
        int bridgeTruckWeight = 0;
        for(int truck : truck_weights)
        {
            while(true){
                if(queue.isEmpty()){ // 다리가 비어있으면
                    queue.offer(truck);
                    answer++;
                    bridgeTruckWeight+=truck;
                    break;
                }else if(queue.size() == bridge_length){
                    bridgeTruckWeight-=queue.poll();
                }else if(bridgeTruckWeight + truck <= weight){
                    queue.offer(truck);
                    answer++;
                    bridgeTruckWeight+=truck;
                    break;
                }else{
                    queue.offer(0);
                    answer++;
                }
            }
        }
        return answer + bridge_length;
    }
}
