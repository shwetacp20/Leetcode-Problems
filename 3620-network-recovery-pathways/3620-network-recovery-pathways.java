import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        Queue<Integer> q = new LinkedList<>();

        int[] deg = indegree.clone();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) q.offer(i);
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] edge : graph[u]) {
                if (--deg[edge[0]] == 0)
                    q.offer(edge[0]);
            }
        }

        int lo = 0;
        int hi = maxCost;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (can(mid, graph, topo, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int limit,
                        List<int[]>[] graph,
                        int[] topo,
                        boolean[] online,
                        long k) {

        int n = online.length;
        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}