import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special handling for 1
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {
            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (true) {
                int count = freq.getOrDefault(cur, 0);

                if (count == 0) {
                    break;
                }

                if (count == 1) {
                    len++;
                    break;
                }

                // count >= 2
                len += 2;

                // Prevent overflow
                if (cur > 1000000000L / cur) {
                    len--;
                    break;
                }

                long next = cur * cur;

                if (!freq.containsKey(next)) {
                    len--;
                    break;
                }

                cur = next;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}