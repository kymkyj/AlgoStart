package programmers;

import java.util.*;

public class proMenuRenew {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(s.solution(orders,course)));
    }
}

class Solution {
    HashMap<String, Integer> hashMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> before = new ArrayList<>(); // 초기화
        StringBuilder sb = new StringBuilder();

        for (String menu : orders) {
            char[] tmp = menu.toCharArray();
            Arrays.sort(tmp);
            for (int i : course) {
                Comb(tmp, sb, 0, 0, i);
            }
        } // 각각의 조합을 만들어 둠.

        for (int i : course) {
            Set<Map.Entry<String, Integer>> entry2 = hashMap.entrySet();

            int max = 0;
            for (Map.Entry<String, Integer> entry : entry2) {
                if (entry.getKey().length() == i) {
                    max = Math.max(max, entry.getValue());
                }
            }
            for (Map.Entry<String, Integer> entry : entry2) {
                if (max > 1 && entry.getValue() == max && entry.getKey().length() == i)
                    before.add(entry.getKey());
            }
        }

        Collections.sort(before);
        String[] answer = new String[before.size()];

        for (int i = 0; i < before.size(); i++) {
            answer[i] = before.get(i);
        }

        return answer;
    }

    public void Comb(char[] order, StringBuilder sb, int start, int n, int r) {
        if (n == r) {
            hashMap.put(sb.toString(), hashMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = start; i < order.length; i++) {
            sb.append(order[i]);
            Comb(order, sb, i + 1, n + 1, r);
            sb.delete(n, n + 1);
        }
    }
}
