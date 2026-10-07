class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] dp1 = new boolean[MAX];
        boolean[] dp2 = new boolean[MAX];
        boolean[] dp3 = new boolean[MAX];

        // One pick
        for (int num : nums) {
            dp1[num] = true;
        }

        // Two picks
        for (int num : nums) {
            for (int x = 0; x < MAX; x++) {
                if (dp1[x]) {
                    dp2[x ^ num] = true;
                }
            }
        }

        // Three picks
        for (int num : nums) {
            for (int x = 0; x < MAX; x++) {
                if (dp2[x]) {
                    dp3[x ^ num] = true;
                }
            }
        }

        int ans = 0;
        for (boolean b : dp3) {
            if (b) ans++;
        }

        return ans;
    }
}