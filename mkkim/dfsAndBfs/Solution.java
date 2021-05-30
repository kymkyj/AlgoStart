
public class Solution {
    private static Map<Integer, List<Integer>> map = new TreeMap<>();
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int nodeNum = sc.nextInt();
        final int edgeNum = sc.nextInt();
        final int firstNode = sc.nextInt();

        for(int i = 0; i < edgeNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.computeIfAbsent(x, s -> new ArrayList<>()).add(y);
            map.computeIfAbsent(y, s -> new ArrayList<>()).add(x);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort(null);
        }
        visited = new boolean[nodeNum + 1];
        dfs(firstNode);
        System.out.println(); //줄바꿈
        visited = new boolean[nodeNum + 1];
        bfs(firstNode);
    }

    static void dfs(int i) {
        System.out.println(i + " ");
        visited[i] = true;
        for (int n  : map.get(i)) {
            if (visited[n] == false) {
                dfs(n);
            }
        }
    }

    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.println(current + " ");
            for (int n : map.get(current)) {
                if (visited[n] == false) {
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }
}
