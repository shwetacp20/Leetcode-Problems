import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // BFS to find maximum depth from root (node 1)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int nei : graph[node]) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        queue.offer(nei);
                    }
                }
            }
        }

        // If only root exists
        if (depth == 0) {
            return 0;
        }

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}