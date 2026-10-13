class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        // Difference array
        int[] diff = new int[2 * limit + 2];

        // Process each pair
        for (int i = 0; i < n / 2; i++) {

            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            /*
               Initially assume:
               all sums need 2 moves
            */
            diff[2] += 2;

            /*
               From (a + 1),
               moves reduce from 2 -> 1
            */
            diff[a + 1] -= 1;

            /*
               At exact sum (a + b),
               moves reduce from 1 -> 0
            */
            diff[a + b] -= 1;

            /*
               After exact sum,
               moves increase from 0 -> 1
            */
            diff[a + b + 1] += 1;

            /*
               After (b + limit),
               moves increase from 1 -> 2
            */
            diff[b + limit + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int moves = 0;

        // Prefix sum to calculate moves
        for (int sum = 2; sum <= 2 * limit; sum++) {

            moves += diff[sum];

            ans = Math.min(ans, moves);
        }

        return ans;
    }
}