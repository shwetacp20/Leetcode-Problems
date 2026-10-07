import java.util.*;

class Solution {
    static class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                prefix[i + 1] = prefix[i] + 1;
            else
                prefix[i + 1] = prefix[i] - 1;
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int x : sorted) {
            if (!map.containsKey(x))
                map.put(x, idx++);
        }

        FenwickTree bit = new FenwickTree(idx + 2);

        long ans = 0;

        for (int x : prefix) {
            int id = map.get(x);

            // Count previous prefix sums smaller than current
            ans += bit.query(id - 1);

            bit.update(id, 1);
        }

        return ans;
    }
}