import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        // If already at last index
        if (n == 1) {
            return 0;
        }

        // Store indices having same values
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int i = q.poll();

                // Reached last index
                if (i == n - 1) {
                    return steps;
                }

                // i + 1
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // i - 1
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // Same value jumps
                if (map.containsKey(arr[i])) {

                    for (int next : map.get(arr[i])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    // Remove to avoid repeated processing
                    map.remove(arr[i]);
                }
            }

            steps++;
        }

        return -1;
    }
}