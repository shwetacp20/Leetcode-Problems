import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        // prime -> indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build map using prime factors
        for (int i = 0; i < n; i++) {

            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {

                if (x % p == 0) {

                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);

                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            // remaining prime factor
            if (x > 1) {
                map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                // left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleport only if nums[i] is prime
                if (isPrime(nums[i])) {

                    int p = nums[i];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!vis[next]) {
                                vis[next] = true;
                                q.offer(next);
                            }
                        }

                        // IMPORTANT: avoid repeated processing
                        map.remove(p);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}