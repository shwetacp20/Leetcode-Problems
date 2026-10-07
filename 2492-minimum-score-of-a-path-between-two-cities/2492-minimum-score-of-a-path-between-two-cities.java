import java.util.*;

class Solution {

    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int[] edge : graph[node]) {

                ans = Math.min(ans, edge[1]);

                if (!visited[edge[0]]) {
                    visited[edge[0]] = true;
                    q.offer(edge[0]);
                }
            }
        }

        return ans;
    }
}