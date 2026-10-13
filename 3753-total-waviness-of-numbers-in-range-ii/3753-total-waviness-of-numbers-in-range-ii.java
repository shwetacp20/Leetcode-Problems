class Solution {

    static class Pair {
        long cnt;
        long waviness;

        Pair(long c, long w) {
            cnt = c;
            waviness = w;
        }
    }

    private String s;
    private Pair[][][][][] memo;
    private boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = String.valueOf(x);

        int n = s.length();

        memo = new Pair[n + 1][11][11][2][4];
        vis = new boolean[n + 1][11][11][2][4];

        return dfs(0, 10, 10, 1, 0).waviness;
    }

    private Pair dfs(int pos, int prev2, int prev1,
                     int tight, int lenStarted) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (vis[pos][prev2][prev1][tight][lenStarted]) {
            return memo[pos][prev2][prev1][tight][lenStarted];
        }

        vis[pos][prev2][prev1][tight][lenStarted] = true;

        long totalCnt = 0;
        long totalWave = 0;

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (lenStarted == 0 && d == 0) {

                Pair child = dfs(pos + 1, 10, 10, ntight, 0);

                totalCnt += child.cnt;
                totalWave += child.waviness;
            } else {

                int newLen = Math.min(3, lenStarted + 1);

                long extra = 0;

                if (lenStarted >= 2) {

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        extra = 1;
                    }
                }

                int nPrev2, nPrev1;

                if (lenStarted == 0) {
                    nPrev2 = 10;
                    nPrev1 = d;
                } else if (lenStarted == 1) {
                    nPrev2 = prev1;
                    nPrev1 = d;
                } else {
                    nPrev2 = prev1;
                    nPrev1 = d;
                }

                Pair child = dfs(
                        pos + 1,
                        nPrev2,
                        nPrev1,
                        ntight,
                        newLen
                );

                totalCnt += child.cnt;
                totalWave += child.waviness + extra * child.cnt;
            }
        }

        return memo[pos][prev2][prev1][tight][lenStarted] =
                new Pair(totalCnt, totalWave);
    }
}