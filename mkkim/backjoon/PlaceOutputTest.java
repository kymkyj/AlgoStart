package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlaceOutputTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] places = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] inputs = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                places[i][j] = inputs[j] - '0';
            }
        }

        outPutPlacesCount(places);
    }

    private static void outPutPlacesCount(int[][] places) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[0].length; j++) {
                if (places[i][j] != 1) continue;
                list.add(dfs(places, i, j));
            }
        }

        output(list);
    }

    private static int dfs(int[][] places, int i, int j) {
        if(i < 0 || i >= places.length || j < 0 || j >= places[0].length || places[i][j] == 0) return 0;
        places[i][j] = 0;
        int count = 1;
        count += dfs(places, i+1, j); // 상
        count += dfs(places, i-1, j); // 하
        count += dfs(places, i, j-1); // 좌
        count += dfs(places, i, j+1); // 우
        return count;
    }

    private static void output(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for(int num : list) sb.append(num + "\n");
        System.out.println(sb.toString());
    }
}
