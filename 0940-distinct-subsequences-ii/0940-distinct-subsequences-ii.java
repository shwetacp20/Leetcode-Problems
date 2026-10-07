class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;

        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long newSubsequences = (total + 1) % MOD;

            total = (total + newSubsequences - dp[idx] + MOD) % MOD;

            dp[idx] = newSubsequences;
        }

        return (int) total;
    }
}