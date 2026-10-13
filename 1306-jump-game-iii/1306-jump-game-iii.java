import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {

        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int i = q.poll();

            if (arr[i] == 0) {
                return true;
            }

            if (visited[i]) continue;
            visited[i] = true;

            int forward = i + arr[i];
            int backward = i - arr[i];

            if (forward < n && !visited[forward]) {
                q.add(forward);
            }

            if (backward >= 0 && !visited[backward]) {
                q.add(backward);
            }
        }

        return false;
    }
}